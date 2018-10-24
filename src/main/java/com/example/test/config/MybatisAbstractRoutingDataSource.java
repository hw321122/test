package com.example.test.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MybatisAbstractRoutingDataSource extends AbstractRoutingDataSource{


    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getDB();

        return typeKey;
    }
}
