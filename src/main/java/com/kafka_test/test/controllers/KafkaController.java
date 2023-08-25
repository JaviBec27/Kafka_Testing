package com.kafka_test.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka_test.test.gateway.producers.KafkaProducerService;

@RestController
public class KafkaController {

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        try {
            producerService.sendMessage(message);
            return new ResponseEntity<>("Mensaje enviado al topic", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al enviar el mensaje: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
