package com.eyalmiz.kafka.rest;

import com.eyalmiz.kafka.payload.Student;
import com.eyalmiz.kafka.producer.KafkaJsonProducer;
import com.eyalmiz.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private  final KafkaProducer kafkaProducer;
    private  final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message queued successfully");

    }
    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("message queued successfully JsonMessage");

    }
}
