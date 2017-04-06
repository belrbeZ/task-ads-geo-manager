package com.keeper.config.setup;

/*
 * Created by @GoodforGod on 29.03.2017.
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
 * Default Comment
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
