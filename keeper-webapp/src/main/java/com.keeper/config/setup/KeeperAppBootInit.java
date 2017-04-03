package com.keeper.config.setup;

/*
 * Created by @GoodforGod on 29.03.2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Default Comment
 */
@SpringBootApplication
@ComponentScan("com.keeper")
@EnableScheduling
public class KeeperAppBootInit {

    public static void main(String[] args) {

        SpringApplication.run(KeeperAppBootInit.class, args);
    }
}
