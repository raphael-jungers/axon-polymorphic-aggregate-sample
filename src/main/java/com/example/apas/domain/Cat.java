package com.example.apas.domain;

import com.example.apas.command.WelcomeCatCommand;
import com.example.apas.event.CatWelcomedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Cat extends Animal {

    private boolean loyal;

    public Cat() {
        // Empty constructor required for Axon
    }

    @CommandHandler
    public Cat(WelcomeCatCommand command) {

        apply(
                CatWelcomedEvent.builder()
                        .aggregateIdentifierAnimal(command.getAggregateIdentifierAnimal())
                        .name(command.getName())
                        .loyal(command.isLoyal())
                        .build()
        );
    }

    @EventSourcingHandler
    public void on(CatWelcomedEvent event) {
        this.aggregateIdentifierAnimal = event.getAggregateIdentifierAnimal();
        this.name = event.getName();
        this.loyal = event.isLoyal();
    }
}
