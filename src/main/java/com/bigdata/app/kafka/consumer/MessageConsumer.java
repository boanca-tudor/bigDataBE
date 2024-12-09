package com.bigdata.app.kafka.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "big-data", groupId = "big-data-consumer")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
