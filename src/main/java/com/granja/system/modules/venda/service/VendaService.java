package com.granja.system.modules.venda.service;

import com.granja.system.modules.venda.entities.Venda;
import com.granja.system.modules.venda.repository.VendaRepository;
import com.granja.system.modules.animal.repository.AnimalRepository;
import com.granja.system.modules.animal.entities.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final AnimalRepository animalRepository;

    public Venda registrar(Venda venda) {
        if (venda.getTipo().equalsIgnoreCase("animal")) {
            Animal animal = animalRepository.findById(venda.getIdAnimal())
                    .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

            if (animal.getQuantidade() < venda.getQuantidade()) {
                throw new RuntimeException("Quantidade insuficiente de animais");
            }

            animal.setQuantidade(animal.getQuantidade() - venda.getQuantidade());
            animalRepository.save(animal);
        }

        return vendaRepository.save(venda);
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public Venda buscarPorId(String id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    public List<Venda> buscarPorTipo(String tipo) {
        return vendaRepository.findByTipo(tipo);
    }

    public List<Venda> buscarPorData(LocalDate data) {
        return vendaRepository.findByData(data);
    }

    public Venda atualizar(String id, Venda vendaAtualizada) {
        Venda venda = buscarPorId(id);
        venda.setTipo(vendaAtualizada.getTipo());
        venda.setQuantidade(vendaAtualizada.getQuantidade());
        venda.setData(vendaAtualizada.getData());
        venda.setValor(vendaAtualizada.getValor());
        venda.setIdAnimal(vendaAtualizada.getIdAnimal());
        return vendaRepository.save(venda);
    }

    public void deletar(String id) {
        buscarPorId(id);
        vendaRepository.deleteById(id);
    }
}