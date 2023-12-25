package com.example.kafkademo.consumer;

import com.example.kafkademo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "myFirstTopic", groupId = "myGroup")
//    public void consumeMessage(String message) {
//        log.info(String.format("Consuming the message from myFirstTopic :: %s", message));
//    }

    @KafkaListener(topics = "myJsonTopic", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        log.info(String.format("Consuming the message from myJsonTopic :: %s", student));
    }
}
