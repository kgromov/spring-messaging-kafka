package com.kafka.example;

import com.kafka.example.events.SyncEvent;
import com.kafka.example.service.Consumer;
import com.kafka.example.service.Producer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

@SpringBootApplication
public class SpringMessagingKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMessagingKafkaApplication.class, args);
	}


	@Bean
	public ApplicationRunner applicationRunner(Producer producer,
											   Consumer consumer,
											   KafkaTemplate<String, SyncEvent> kafkaTemplate){
		return args -> {
			producer.sendSynEvent();
			List<PartitionInfo> partitionInfos = kafkaTemplate.partitionsFor("sync-weather");
			/*int partition = partitionInfos.get(0).partition();
			String topic = partitionInfos.get(0).topic();
			ConsumerRecord<String, SyncEvent> consumerRecord = kafkaTemplate.receive(topic, partition, 0);
			SyncEvent receivedEvent = consumerRecord.value();*/
		};
	}
}
