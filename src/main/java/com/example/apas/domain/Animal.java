package com.example.apas.domain;

import com.example.apas.command.RenameAnimalCommand;
import com.example.apas.event.AnimalRenamedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public abstract class Animal {

    @AggregateIdentifier
    protected String aggregateIdentifierAnimal;

    protected String name;

    protected Animal() {
        // Empty constructor required for Axon
    }

    @CommandHandler
    public void handle(RenameAnimalCommand command) {

        AggregateLifecycle.apply(
                AnimalRenamedEvent.builder()
                        .aggregateIdentifierAnimal(command.getAggregateIdentifierAnimal())
                        .build()
        );
    }

    @EventSourcingHandler
    public void on(AnimalRenamedEvent event) {
        this.name = event.getName();
    }
}
