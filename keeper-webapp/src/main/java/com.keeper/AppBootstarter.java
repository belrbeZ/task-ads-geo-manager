package com.keeper;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Application Spring Boot Starter
 */
@SpringBootApplication
@ComponentScan("com.keeper")
@EnableAutoConfiguration
//@Import(SwaggerConfig.class)
public class AppBootstarter {
    public static void main(String[] args) {
        SpringApplication.run(AppBootstarter.class, args);
    }
}
