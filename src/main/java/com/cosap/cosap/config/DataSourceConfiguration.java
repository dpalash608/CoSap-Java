package com.cosap.cosap.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static java.lang.System.getenv;

@Configuration
public class DataSourceConfiguration
{
    private static class Constants
    {
        private static final String SECURE_JDBC = "true";
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariProperties ()
    {
        return new HikariConfig();
    }

    @Profile("cf")
    @Bean
    public HikariDataSource createCloudDataSource (HikariConfig config)
    {
        config.addDataSourceProperty("encrypt", "true");
        config.addDataSourceProperty("validateCertificate", "true");
        return new HikariDataSource(config);
    }

    @Profile("local")
    @Bean
    public HikariDataSource createDevDataSource (HikariConfig config)
    {
        String secure = getenv(Constants.SECURE_JDBC);
        if ("true".equals(secure)) {
            config.addDataSourceProperty("encrypt", "true");
            config.addDataSourceProperty("validateCertificate", "false");
        }
        return new HikariDataSource(config);
    }
}
