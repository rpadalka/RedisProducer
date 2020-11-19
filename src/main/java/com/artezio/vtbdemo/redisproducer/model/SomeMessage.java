package com.artezio.vtbdemo.redisproducer.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SomeMessage {
    private String name;
    private String message;
}
