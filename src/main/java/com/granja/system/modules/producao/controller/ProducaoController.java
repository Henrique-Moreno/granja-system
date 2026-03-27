package com.granja.system.modules.producao.controller;

import com.granja.system.modules.producao.entities.Producao;
import com.granja.system.modules.producao.service.ProducaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/producoes")
@RequiredArgsConstructor
public class ProducaoController {

    private final ProducaoService producaoService;

    @PostMapping
    public ResponseEntity<Producao> registrar(@RequestBody @Valid Producao producao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(producaoService.registrar(producao));
    }

    @GetMapping
    public ResponseEntity<List<Producao>> listarTodas() {
        return ResponseEntity.ok(producaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producao> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(producaoService.buscarPorId(id));
    }

    @GetMapping("/data/{data}")
    public ResponseEntity<List<Producao>> buscarPorData(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(producaoService.buscarPorData(data));
    }

    @GetMapping("/animal/{idAnimal}")
    public ResponseEntity<List<Producao>> buscarPorIdAnimal(@PathVariable String idAnimal) {
        return ResponseEntity.ok(producaoService.buscarPorIdAnimal(idAnimal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producao> atualizar(@PathVariable String id, @RequestBody @Valid Producao producao) {
        return ResponseEntity.ok(producaoService.atualizar(id, producao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        producaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}