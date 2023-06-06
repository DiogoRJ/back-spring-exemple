package com.diogorj.back.kafka.consumer;

import com.diogorj.back.entity.Endereco;
import com.diogorj.back.service.EnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Log4j2
@Service
public class EnderecoConsumer {

    @Autowired
    private EnderecoService enderecoService;

    @KafkaListener(topics = "${topic.endereco-client}", groupId = "${spring.kafka.consumer.group-id}")
    public void obterEndereco(String enderecoString) throws JsonProcessingException {


        log.info("Msg Endereco {}", enderecoString);

        ObjectMapper objectMapper = new ObjectMapper();
        Endereco endereco = objectMapper.readValue(enderecoString, Endereco.class);

        enderecoService.create(endereco);
        log.info("Endereco salvo na base com sucesso: {}", endereco);

    }


}
