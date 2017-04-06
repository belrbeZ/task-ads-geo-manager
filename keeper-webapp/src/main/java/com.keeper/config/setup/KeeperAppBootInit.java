package com.keeper.config.setup;

/*
 * Created by @Alex Vasil on 06.04.2017.
 */

import com.keeper.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * MODULE VERSION
 * NO ERRORS
 */


@SpringBootApplication
@ComponentScan("com.keeper")
//@EnableScheduling
//@EnableAutoConfiguration
//@Import(SwaggerConfig.class)
public class KeeperAppBootInit {
    public static void main(String[] args) {
        SpringApplication.run(KeeperAppBootInit.class, args);
    }

}
