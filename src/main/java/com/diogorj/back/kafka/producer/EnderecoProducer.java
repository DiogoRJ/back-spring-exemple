package com.diogorj.back.kafka.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EnderecoProducer {

    @Value("${topic.endereco-client}")
    private String topicEnderecoClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(topicEnderecoClient, message);
        log.info("Mensagem enviada para o topic -> "+topicEnderecoClient+": {}", message);
    }
}
