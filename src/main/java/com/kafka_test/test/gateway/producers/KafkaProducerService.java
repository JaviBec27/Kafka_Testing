package com.kafka_test.test.gateway.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC_NAME = "test4-topic"; // Cambia por el nombre de tu tópico

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        try {

            System.out.println("*********************************");
            System.out.println(message);
            System.out.println("*********************************");
            kafkaTemplate.send(TOPIC_NAME, message);
            System.out.println("*********************************");
            System.out.println("*********************************");

        } catch (Exception e) {
            // Manejar la excepción aquí, por ejemplo, imprimir un mensaje de error
            e.printStackTrace();
        }
    }

    public void sendMessageWithKey(String key, String message) {

        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, message);
            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(getProperties());

            kafkaProducer.send(record);
            kafkaProducer.close();
        } catch (Exception e) {
            // Manejar la excepción aquí, por ejemplo, imprimir un mensaje de error
            e.printStackTrace();
        }
    }

    private Properties getProperties() {

        Properties prop = new Properties();
        prop.put("bootstrap.servers", "localhost:9092");
        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return prop;
    }
}
