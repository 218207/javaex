package com.example.task42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserManagerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }
}

