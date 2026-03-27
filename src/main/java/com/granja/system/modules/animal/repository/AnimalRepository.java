package com.granja.system.modules.animal.repository;

import com.granja.system.modules.animal.entities.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {

    List<Animal> findByTipo(String tipo);
    List<Animal> findByIdade(Integer idade);
    List<Animal> findByDataEntrada(LocalDate dataEntrada);
}