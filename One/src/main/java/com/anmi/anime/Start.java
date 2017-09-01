package com.anmi.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wangjue on 2017/8/21.
 */
@SpringBootApplication
@EnableScheduling
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }
}
