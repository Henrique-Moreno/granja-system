package com.granja.system.modules.producao.service;

import com.granja.system.modules.producao.entities.Producao;
import com.granja.system.modules.producao.repository.ProducaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducaoService {

    private final ProducaoRepository producaoRepository;

    public Producao registrar(Producao producao) {
        return producaoRepository.save(producao);
    }

    public List<Producao> listarTodas() {
        return producaoRepository.findAll();
    }

    public Producao buscarPorId(String id) {
        return producaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produção não encontrada"));
    }

    public List<Producao> buscarPorData(LocalDate data) {
        return producaoRepository.findByData(data);
    }

    public List<Producao> buscarPorIdAnimal(String idAnimal) {
        return producaoRepository.findByIdAnimal(idAnimal);
    }

    public Producao atualizar(String id, Producao producaoAtualizada) {
        Producao producao = buscarPorId(id);
        producao.setData(producaoAtualizada.getData());
        producao.setQuantidadeOvos(producaoAtualizada.getQuantidadeOvos());
        producao.setIdAnimal(producaoAtualizada.getIdAnimal());
        return producaoRepository.save(producao);
    }

    public void deletar(String id) {
        buscarPorId(id);
        producaoRepository.deleteById(id);
    }
}