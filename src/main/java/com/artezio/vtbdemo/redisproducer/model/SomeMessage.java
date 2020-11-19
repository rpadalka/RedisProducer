package com.artezio.vtbdemo.redisproducer.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SomeMessage implements Serializable {
    private static final long serialVersionUID = 553215874062476335L;

    private String name;
    private String message;
}
