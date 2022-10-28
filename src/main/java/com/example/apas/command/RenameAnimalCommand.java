package com.example.apas.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RenameAnimalCommand {

    @TargetAggregateIdentifier
    private String aggregateIdentifierAnimal;

    private String name;
}
