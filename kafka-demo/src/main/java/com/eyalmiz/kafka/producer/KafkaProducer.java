package com.eyalmiz.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String msg){
    log.info(String.format("send message Topic to testDemo :: %s ",msg));
    kafkaTemplate.send("demo1",msg);
    }
}
