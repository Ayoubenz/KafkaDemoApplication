package com.example.kafkademo.controller;

import com.example.kafkademo.payload.Student;
import com.example.kafkademo.producer.KafkaJsonProducer;
import com.example.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages/")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;


    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message)
    {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message was sent");
    }

    @PostMapping("json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student)
    {
        kafkaJsonProducer.sendJsonMessage(student);
        return ResponseEntity.ok("Student was sent");
    }
}
