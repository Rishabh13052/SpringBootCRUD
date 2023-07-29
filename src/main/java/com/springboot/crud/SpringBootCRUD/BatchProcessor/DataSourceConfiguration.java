package com.springboot.crud.SpringBootCRUD.BatchProcessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceConfiguration {

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;
    @Bean
    public DataSource getDataSource() {
        //System.out.println("dataSource " +dataSource);
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.driverClassName(this.driverClassName);
        dataSource.url(this.url);
        dataSource.username(this.userName);
        dataSource.password(this.password);

        return dataSource.build();
    }
}
