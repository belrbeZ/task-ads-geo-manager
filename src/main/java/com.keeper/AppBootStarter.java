package com.keeper;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main Application Spring Boot Starter
 */
@EnableScheduling
@SpringBootApplication
public class AppBootStarter  {
    public static void main(String[] args) {
        SpringApplication.run(AppBootStarter.class, args);
    }
}
