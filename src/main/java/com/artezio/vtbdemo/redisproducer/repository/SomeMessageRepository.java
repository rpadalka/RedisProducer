package com.artezio.vtbdemo.redisproducer.repository;

import com.artezio.vtbdemo.redisproducer.model.SomeMessage;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SomeMessageRepository {

    private final RedisTemplate<Long, SomeMessage> redisTemplate;

    public void save(SomeMessage someMessage) {
        redisTemplate.opsForValue().set(someMessage.getId(), someMessage);
    }

    public SomeMessage findById(Long id) {
        return redisTemplate.opsForValue().get(id);
    }
}
