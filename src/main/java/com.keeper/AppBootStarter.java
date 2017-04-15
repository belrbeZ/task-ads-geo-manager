package com.keeper;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Main Application Spring Boot Starter
 */
@SpringBootApplication
//@EnableAsync //Unnecessary! for hot swapping, disable cache for template, enable live reload
public class AppBootStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppBootStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppBootStarter.class);
    }

}
