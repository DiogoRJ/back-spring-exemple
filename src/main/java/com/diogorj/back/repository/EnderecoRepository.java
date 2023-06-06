package com.diogorj.back.repository;

import com.diogorj.back.entity.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    public Endereco save(Endereco endereco);
}