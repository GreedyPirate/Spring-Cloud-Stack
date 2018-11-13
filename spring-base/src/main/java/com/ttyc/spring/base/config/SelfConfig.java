package com.ttyc.spring.base.config;

import com.ttyc.spring.base.model.SuperUser;
import com.ttyc.spring.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class SelfConfig {

    @Autowired
    User user;

    @Value("${user.name}")
    String name;

    @Bean
    public User user() {
        return new User(1L,name,"1234");
    }

    @Bean
    public SuperUser superUser(){
        SuperUser superUser = new SuperUser();
        superUser.setUser(user);
        return superUser;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
