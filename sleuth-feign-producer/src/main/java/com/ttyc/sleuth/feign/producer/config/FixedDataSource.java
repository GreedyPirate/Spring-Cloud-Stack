package com.ttyc.sleuth.feign.producer.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class FixedDataSource {
    @Bean
    DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("0817");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/aicar?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&statementInterceptors=brave.mysql.TracingStatementInterceptor&zipkinServiceName=mysqlTrace");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;
    }
}
