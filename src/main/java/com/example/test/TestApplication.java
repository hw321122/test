package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
       // log.info("事务管理器:{}" + platformTransactionManager.getClass().getName());
        System.out.println("事务管理器:{}" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}
