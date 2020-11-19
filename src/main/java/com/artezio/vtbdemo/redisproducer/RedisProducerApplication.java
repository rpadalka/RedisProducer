package com.artezio.vtbdemo.redisproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RedisProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisProducerApplication.class, args);
    }

}
