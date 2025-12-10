package com.pluralsight.NorthwindTradersSpringBoot.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfiguration {
    private final BasicDataSource basicDataSource;

    @Bean
    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }

    public DatabaseConfiguration(@Value("${datasource.url}") String url,
                                 @Value("${datasource.username}") String username,
                                 @Value("${datasource.password}") String password) {


        this.basicDataSource = new BasicDataSource();
        this.basicDataSource.setUrl(url);
        this.basicDataSource.setUsername(username);
        this.basicDataSource.setPassword(password);
    }
}
