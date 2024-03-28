package com.eyalmiz.wikimedia.producer.rest;

import com.eyalmiz.wikimedia.producer.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
@Slf4j
public class WikimediaController {
    private final WikimediaStreamConsumer streamConsumer;

    @GetMapping
    public void startPublishing() {
        log.info("hello");
        streamConsumer.consumeStreamAndPublish();
    }
}
