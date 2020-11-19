package com.artezio.vtbdemo.redisproducer.repository;

import com.artezio.vtbdemo.redisproducer.model.SomeMessage;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.connection.stream.StringRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class SomeMessageRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public String save(String streamName, SomeMessage someMessage) {
        Map<String, String> fields = new HashMap<>();
        fields.put("name", someMessage.getName());
        fields.put("message", someMessage.getMessage());
        StringRecord record = StreamRecords.newRecord().ofStrings(fields).withStreamKey(streamName);
        RecordId recordId = redisTemplate.opsForStream().add(record);

        return Objects.requireNonNull(recordId).getValue();
    }

    public Long getSize(String streamName) {
        return redisTemplate.opsForStream().size(streamName);
    }
}
