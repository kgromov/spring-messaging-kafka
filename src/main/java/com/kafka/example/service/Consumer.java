package com.kafka.example.service;

import com.kafka.example.events.SyncEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Consumer {
    private final KafkaTemplate<String, SyncEvent> kafkaTemplate;

    @KafkaListener(
            topics = "${spring.kafka.template.default-topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void onSyncEvent(SyncEvent event) {
        log.info("Event {} received", event);
    }
}
