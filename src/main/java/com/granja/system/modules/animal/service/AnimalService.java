package com.granja.system.modules.animal.service;

import com.granja.system.modules.animal.entities.Animal;
import com.granja.system.modules.animal.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public Animal cadastrar(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(String id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public List<Animal> buscarPorTipo(String tipo) {
        return animalRepository.findByTipo(tipo);
    }

    public List<Animal> buscarPorIdade(Integer idade) {
        return animalRepository.findByIdade(idade);
    }

    public List<Animal> buscarPorDataEntrada(LocalDate dataEntrada) {
        return animalRepository.findByDataEntrada(dataEntrada);
    }

    public Animal atualizar(String id, Animal animalAtualizado) {
        Animal animal = buscarPorId(id);
        animal.setTipo(animalAtualizado.getTipo());
        animal.setQuantidade(animalAtualizado.getQuantidade());
        animal.setIdade(animalAtualizado.getIdade());
        animal.setDataEntrada(animalAtualizado.getDataEntrada());
        return animalRepository.save(animal);
    }

    public String deletar(String id) {
        buscarPorId(id);
        animalRepository.deleteById(id);
        return "Animal removido com sucesso!";
    }
}