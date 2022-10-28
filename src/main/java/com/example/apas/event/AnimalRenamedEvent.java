package com.example.apas.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalRenamedEvent {

    private String aggregateIdentifierAnimal;

    private String name;
}
