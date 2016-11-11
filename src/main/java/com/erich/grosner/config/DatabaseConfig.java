package com.erich.grosner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

    @Autowired
    EnvironmentConfig envConfig;

    @Bean
    public javax.sql.DataSource dataSource(DataSourceProperties properties) throws URISyntaxException {

        if(envConfig.getJawsdbUrl() == null) {
            return properties.initializeDataSourceBuilder().build();
        }
        else {
            URI jdbUri = new URI(envConfig.getJawsdbUrl());
            String username = jdbUri.getUserInfo().split(":")[0];
            String password = jdbUri.getUserInfo().split(":")[1];
            String port = String.valueOf(jdbUri.getPort());
            String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();

            return properties.initializeDataSourceBuilder()
                    .username(username)
                    .password(password)
                    .url(jdbUrl)
                    .build();
        }
    }
}
