package com.artezio.vtbdemo.redisproducer.controller;

import com.artezio.vtbdemo.redisproducer.model.SomeMessage;
import com.artezio.vtbdemo.redisproducer.repository.SomeMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class SomeMessageController {
    private final SomeMessageRepository repository;

    @PostMapping("/create")
    public String newMessage(@RequestBody SomeMessage newMessage) {
        repository.save(newMessage);

        return "Some message added";
    }

    @GetMapping("/get/{id}")
    public SomeMessage findById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
