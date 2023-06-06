package com.diogorj.back.service.impl;

import com.diogorj.back.client.ViaCepClient;
import com.diogorj.back.dto.EnderecoJsonDTO;
import com.diogorj.back.dto.EnderecoResponseDTO;
import com.diogorj.back.entity.Endereco;
import com.diogorj.back.kafka.producer.EnderecoProducer;
import com.diogorj.back.repository.EnderecoRepository;
import com.diogorj.back.service.EnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoProducer enderecoProducer;
    private final ViaCepClient viaCepClient;
    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoProducer enderecoProducer, ViaCepClient viaCepClient, EnderecoRepository enderecoRepository) {
        this.enderecoProducer = enderecoProducer;
        this.viaCepClient = viaCepClient;
        this.enderecoRepository = enderecoRepository;
    }


    @Override
    public EnderecoResponseDTO enviarEndereco(EnderecoJsonDTO enderecoJson) throws JsonProcessingException {
        EnderecoResponseDTO enderecoResponse = viaCepClient.obterEndereco(enderecoJson.getCep());

        enderecoResponse.setComplemento(enderecoJson.getComplemento());
        enderecoResponse.setNumero(enderecoJson.getNumero());

        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(enderecoResponse);

        enderecoProducer.sendMessage(mensagem);
        log.info("# Endereço retornado pela API CEP: {}", enderecoResponse);
        return enderecoResponse;
    }

    @Override
    public Endereco create(Endereco endereco) {
        enderecoRepository.save(endereco);
        return endereco;
    }

    @Override
    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }
}
