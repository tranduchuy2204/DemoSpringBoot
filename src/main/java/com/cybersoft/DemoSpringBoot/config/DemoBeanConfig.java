package com.cybersoft.DemoSpringBoot.config;

import com.cybersoft.DemoSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeanConfig {
    @Bean
//    @Qualifier("abc") => gọi bean sử dụng với tên chỉ định
    public User createBeanUser(){
        User user = new User();
        user.setFullName("Cybersoft");
        user.setAge(5);
        user.setGender(true);
        return user;
    }
}
