package com.diogorj.back.controller;

import com.diogorj.back.client.ViaCepClient;
import com.diogorj.back.dto.EnderecoJsonDTO;
import com.diogorj.back.dto.EnderecoResponseDTO;
import com.diogorj.back.entity.Endereco;
import com.diogorj.back.service.EnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("endereco")
public class EnderecoController {

    private final ViaCepClient viaCepClient;
    private final EnderecoService enderecoService;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<EnderecoResponseDTO> obterEndereco(@PathVariable String cep) {
        EnderecoResponseDTO enderecoResponseDTO = viaCepClient.obterEndereco(cep);
        return ResponseEntity.ok(enderecoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> enviarEndereco(@RequestBody EnderecoJsonDTO enderecoJson) throws JsonProcessingException {

        log.info("# Dados enviados pelo cliente: {}", enderecoJson);

        EnderecoResponseDTO enderecoResponse = enderecoService.enviarEndereco(enderecoJson);

        return ResponseEntity.ok(enderecoResponse);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }
}
