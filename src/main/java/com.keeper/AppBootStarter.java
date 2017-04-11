package com.keeper;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import com.keeper.config.AppServletConfig;
import com.keeper.config.AppWebConfig;
import com.keeper.config.JpaSpringDataConfig;
import com.keeper.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main Application Spring Boot Starter
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.keeper")
@EnableAutoConfiguration
@EnableScheduling
@Import({AppServletConfig.class, SwaggerConfig.class})//, JpaSpringDataConfig.class

public class AppBootStarter extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppBootStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppBootStarter.class);
    }


}
