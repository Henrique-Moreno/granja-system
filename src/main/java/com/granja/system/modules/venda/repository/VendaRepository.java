package com.granja.system.modules.venda.repository;

import com.granja.system.modules.venda.entities.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {

    List<Venda> findByTipo(String tipo);
    List<Venda> findByData(LocalDate data);
}
