package com.keeper.config.setup;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Default Comment
 */
@SpringBootApplication
@ComponentScan("com.keeper")
@EnableScheduling
@EnableAutoConfiguration
public class KeeperAppBootInit {// extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(KeeperAppBootInit.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
////        return super.configure(builder);
//        return application.sources(KeeperAppBootInit.class);
//    }
}
