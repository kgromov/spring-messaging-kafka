package com.kafka.example.service;

import com.kafka.example.events.SyncEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {
    private final KafkaTemplate<String, SyncEvent> kafkaTemplate;

    public void sendSynEvent() {
        log.info("About to send sync event");
        log.info("Default topic = {}", kafkaTemplate.getDefaultTopic());
//        kafkaTemplate.sendDefault(SyncEvent.createDefault());
        kafkaTemplate.send(kafkaTemplate.getDefaultTopic(), SyncEvent.createDefault())
                .thenApply(SendResult::getRecordMetadata)
                .thenAccept(metadata -> log.info("Metadata = {}", metadata));
        log.info("Sent sync event");
    }
}
