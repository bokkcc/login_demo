package com.bokkcc.login_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author : bokkcc
 * @since : 2022.12.19
 */
@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public InMemoryUserDetailsManager configure(AuthenticationManagerBuilder auth) throws Exception {
        var admin = User.builder()
                .username("admin@bokkcc.com")
                .password("love")
                .passwordEncoder(passwordEncoder()::encode)
                .roles("admin")
                .build();

        var user = User.builder()
                .username("role@bokkcc.com")
                .password("love")
                .passwordEncoder(passwordEncoder()::encode)
                .roles("role")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(it -> it.anyRequest().authenticated())
                .formLogin(it -> it
                                .loginPage("/login.html")
//                        .loginProcessingUrl("/doLogin")
                                .usernameParameter("email")
                                .passwordParameter("passwd")
//                        .successForwardUrl("/home") //重定向
                                .defaultSuccessUrl("/home") //调整
                                .permitAll()
                )
                .logout(it -> it
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                        .logoutSuccessUrl("/login.html")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                )
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**");
    }
}
