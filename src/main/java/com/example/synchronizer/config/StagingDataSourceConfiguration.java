package com.example.synchronizer.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@ConfigurationProperties(prefix = "spring.datasource.staging")
public class StagingDataSourceConfiguration {


    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public DataSource getDataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName(getDriverClassName())
                .url(getUrl())
                .username(getUsername())
                .password(getPassword())
                .build();
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
