package com.artezio.vtbdemo.redisproducer.controller;

import com.artezio.vtbdemo.redisproducer.model.SomeMessage;
import com.artezio.vtbdemo.redisproducer.repository.SomeMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor()
public class SomeMessageController {

    private final SomeMessageRepository repository;

    @PostMapping(value = "/create")
    public String newMessage(@RequestBody SomeMessage message) {
        return repository.save(message);
    }

    @GetMapping("/get")
    public Long getInfo() {
        return repository.getSize();
    }
}
