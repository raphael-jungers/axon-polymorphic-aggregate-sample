package com.example.apas;

import com.example.apas.command.RenameAnimalCommand;
import com.example.apas.command.WelcomeCatCommand;
import com.example.apas.command.WelcomeDogCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BugSample {

    private final CommandGateway commandGateway;

    public BugSample(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

        log.info("Starting to send commands...");

        log.info("Sending WelcomeCatCommand...");
        String aggregateIdentifierFelix = UUID.randomUUID().toString();
        commandGateway.sendAndWait(
                WelcomeCatCommand.builder()
                        .aggregateIdentifierAnimal(aggregateIdentifierFelix)
                        .name("Felix")
                        .loyal(false)
                        .build()
        );
        log.info("WelcomeCatCommand sent");

        log.info("Sending WelcomeDogCommand...");
        String aggregateIdentifierMilou = UUID.randomUUID().toString();
        commandGateway.sendAndWait(
                WelcomeDogCommand.builder()
                        .aggregateIdentifierAnimal(aggregateIdentifierMilou)
                        .name("Milou")
                        .sleepy(true)
                        .build()
        );
        log.info("WelcomeDogCommand sent");

        log.info("Sending RenameAnimalCommand...");
        commandGateway.sendAndWait(
                RenameAnimalCommand.builder()
                        .aggregateIdentifierAnimal(aggregateIdentifierMilou)
                        .name("Médor")
                        .build()
        );
        log.info("RenameAnimalCommand sent");
    }
}
