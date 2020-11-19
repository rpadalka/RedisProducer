package com.artezio.vtbdemo.redisproducer.config;

import com.artezio.vtbdemo.redisproducer.model.SomeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {
    @Value("${app.redis.stream.name}") String streamName;

    @Bean
    public RedisTemplate<String, SomeMessage> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, SomeMessage> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
