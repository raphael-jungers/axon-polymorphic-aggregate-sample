package com.example.apas.domain;

import com.example.apas.command.WelcomeDogCommand;
import com.example.apas.event.DogWelcomedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Dog extends Animal {

    private boolean sleepy;

    public Dog() {
        // Empty constructor required for Axon
    }

    @CommandHandler
    public Dog(WelcomeDogCommand command) {

        apply(
                DogWelcomedEvent.builder()
                        .aggregateIdentifierAnimal(command.getAggregateIdentifierAnimal())
                        .name(command.getName())
                        .sleepy(command.isSleepy())
                        .build()
        );
    }

    @EventSourcingHandler
    public void on(DogWelcomedEvent event) {
        this.aggregateIdentifierAnimal = event.getAggregateIdentifierAnimal();
        this.name = event.getName();
        this.sleepy = event.isSleepy();
    }
}
