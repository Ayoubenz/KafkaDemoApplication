package com.example.kafkademo.producer;

import com.example.kafkademo.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendJsonMessage(Student student)
    {
        Message<Student> message = MessageBuilder.withPayload(student)
                        .setHeader(KafkaHeaders.TOPIC,"myJsonTopic").build();
        kafkaTemplate.send(message);
    }

}
