package com.Guddu.UserManagementApp.configuration;

import com.Guddu.UserManagementApp.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {

    @Bean
    public List<User> getUsers(){

        return new ArrayList<>();
    }
}
