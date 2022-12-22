package com.bokkcc.login_demo.config;

import com.bokkcc.login_demo.model.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.NonceExpiredException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * @author : bokkcc
 * @since : 2022.12.19
 */
@Configuration
public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(AuthenticationManagerBuilder auth) {

        var manager = new JdbcUserDetailsManager(dataSource);

        var admin = User.builder()
                .username("admin")
                .password("love")
                .passwordEncoder(passwordEncoder()::encode)
                .roles("admin")
                .build();

        var user = User.builder()
                .username("role@bokkcc.com")
                .password("love")
                .passwordEncoder(passwordEncoder()::encode)
                .roles("user")
                .build();

        if (!manager.userExists(admin.getUsername())) {
            manager.createUser(admin);
        }

        if (!manager.userExists(user.getUsername())) {
            manager.createUser(user);

        }


        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(it -> it
                        // 注意顺序，上面的优先级更高
                        .requestMatchers("/customers/**", "/vendors/**").hasRole("admin")
                        .requestMatchers("/products/**").hasAnyRole("admin", "user")
                        .requestMatchers("/css/**","/js/**").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(it -> it
                        .loginProcessingUrl("/login.html")
                        .loginProcessingUrl("/doLogin")
                        .usernameParameter("email")
                        .passwordParameter("passwd")
                        .successHandler(((request, response, authentication) -> {
                            response.setContentType("application/json;charset=utf-8");
                            var writer = response.getWriter();
                            writer.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
                            writer.flush();
                            writer.close();
                        }))
                        .failureHandler(((request, response, authException) -> {
                            response.setContentType("application/json;charset=utf-8");
                            var writer = response.getWriter();
                            var respBean = RespBean.error(authException.getMessage());
                            if (authException instanceof LockedException) {
                                respBean.setMsg("账户被锁定，请联系管理员!");
                            } else if (authException instanceof CredentialsExpiredException) {
                                respBean.setMsg("密码过期，请联系管理员!");
                            } else if (authException instanceof NonceExpiredException) {
                                respBean.setMsg("账户过期，请联系管理员!");
                            } else if (authException instanceof DisabledException) {
                                respBean.setMsg("账户被禁用，请联系管理员!");
                            } else if (authException instanceof BadCredentialsException) {
                                respBean.setMsg("用户名或者密码输入错误，请重新输入!");
                            }
                            writer.write(new ObjectMapper().writeValueAsString(respBean));
                            writer.flush();
                            writer.close();
                        }))
                        .permitAll()
                )
                .logout(it -> it
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                        .logoutSuccessHandler(((request, response, authentication) -> {
                            response.setContentType("application/json;charset=utf-8");
                            var writer = response.getWriter();
                            writer.write(new ObjectMapper().writeValueAsString(RespBean.ok("注消成功")));
                            writer.flush();
                            writer.close();
                        }))
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                )
                .exceptionHandling(httpSecurityExceptionHandlingConfigurer -> {
                    httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint((request, response, authException) -> {
                        response.setContentType("application/json;charset=utf-8");
                        var writer = response.getWriter();
                        writer.write(new ObjectMapper().writeValueAsString(RespBean.error("尚未登录，请登录。")));
                        writer.flush();
                        writer.close();
                    });
                })
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
