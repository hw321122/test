package com.example.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "readDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource readDataSource(){
        return DataSourceBuilder.create().type(dataSourceType).build();


    }

    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource writeDataSource(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }


}
