package com.kafka.example.service;

import com.kafka.example.events.SyncEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {
   private final KafkaTemplate<String, SyncEvent> kafkaTemplate;

    public void sendSynEvent() {
        log.info("About to send sync event");
        log.info("Default topic = {}", kafkaTemplate.getDefaultTopic());
//        kafkaTemplate.sendDefault(SyncEvent.createDefault());
        kafkaTemplate.send( kafkaTemplate.getDefaultTopic(), SyncEvent.createDefault());
        log.info("Sent sync event");
    }
}
