package com.example.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.common", "com.example.provider"})
@SpringBootApplication
@EnableEurekaClient
public class H2DatabaseProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(H2DatabaseProjectApplication.class, args);
    }
}
