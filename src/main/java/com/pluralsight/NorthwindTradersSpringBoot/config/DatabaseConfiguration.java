package com.pluralsight.NorthwindTradersSpringBoot.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfiguration {
    private BasicDataSource basicDataSource;

    @Bean
    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }

    public DatabaseConfiguration() {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "";
        String password = "";

        this.basicDataSource = new BasicDataSource();
        this.basicDataSource.setUrl(url);
        this.basicDataSource.setUsername(username);
        this.basicDataSource.setPassword(password);

    }
}
