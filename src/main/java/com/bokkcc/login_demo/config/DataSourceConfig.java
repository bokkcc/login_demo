package com.bokkcc.login_demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author : bokkcc
 * @since : 2022.12.19
 */
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource(){
        return DataSourceBuilder.create()
                .username("bokkcc")
                .password("using#001")
                .url("jdbc:h2:mem:db")
                .build();
    }
}
