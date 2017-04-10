package com.keeper;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main Application Spring Boot Starter
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("com.keeper.*")
@EntityScan(basePackages = "com.keeper.entity.dao")
@EnableJpaRepositories(basePackages =  {"com.keeper.repo", "com.keeper.repo.*"})
//@Import(SwaggerConfig.class)
public class AppBootstarter {
    public static void main(String[] args) {
        SpringApplication.run(AppBootstarter.class, args);
    }
}
