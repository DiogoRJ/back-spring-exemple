package com.diogorj.back.service;

import com.diogorj.back.dto.EnderecoJsonDTO;
import com.diogorj.back.dto.EnderecoResponseDTO;
import com.diogorj.back.entity.Endereco;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoService {
    EnderecoResponseDTO enviarEndereco(EnderecoJsonDTO enderecoJson) throws JsonProcessingException;
    Endereco create(Endereco endereco);
    List<Endereco> findAll();
}
