package com.example.apas.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogWelcomedEvent {

    private String aggregateIdentifierAnimal;

    private String name;

    private boolean sleepy;
}
