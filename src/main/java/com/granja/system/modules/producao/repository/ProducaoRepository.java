package com.granja.system.modules.producao.repository;

import com.granja.system.modules.producao.entities.Producao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProducaoRepository extends MongoRepository<Producao, String> {

    List<Producao> findByData(LocalDate data);
    List<Producao> findByIdAnimal(String idAnimal);
}