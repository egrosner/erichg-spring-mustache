package com.erich.grosner.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@Data
public class EnvironmentConfig {

    private String jawsdbUrl;

}
