package com.example.test.interceptor;

import com.example.test.config.DataSourceContextHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAOP {

    @Before("execution(* com.example.test.service..*.select*(..)) || execution(* com.example.test.service..*.get*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.setDB("readDataSource");
        System.out.println("dataSource切换到：Read");
    }


    @Before("execution(* com.example.test.service..*.insert*(..)) || execution(* com.example.test.service..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setDB("writeDataSource");
        System.out.println("dataSource切换到：write");
    }

    @After("execution(* com.example.test.service..*.*(..)) ")
    public void clearDataSourceType() {
        DataSourceContextHolder.clearDB();
        System.out.println("dataSource：clearDataSourceType");
    }

}
