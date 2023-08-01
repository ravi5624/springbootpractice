package com.helloworldgroup.helloworld.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "firstDataSource")
    public DataSource createDataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/college");
        builder.username("postgres");
        builder.password("postgres");
        builder.driverClassName("org.postgresql.Driver");
        return builder.build();
    }
}
