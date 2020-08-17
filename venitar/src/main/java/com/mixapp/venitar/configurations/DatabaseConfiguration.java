package com.mixapp.venitar.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public javax.sql.DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(primaryDataSource());
    }
}
