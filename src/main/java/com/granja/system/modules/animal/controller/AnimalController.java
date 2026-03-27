package com.granja.system.modules.animal.controller;

import com.granja.system.modules.animal.entities.Animal;
import com.granja.system.modules.animal.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody @Valid Animal animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.cadastrar(animal));
    }

    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
        return ResponseEntity.ok(animalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Animal>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(animalService.buscarPorTipo(tipo));
    }

    @GetMapping("/idade/{idade}")
    public ResponseEntity<List<Animal>> buscarPorIdade(@PathVariable Integer idade) {
        return ResponseEntity.ok(animalService.buscarPorIdade(idade));
    }

    @GetMapping("/data/{dataEntrada}")
    public ResponseEntity<List<Animal>> buscarPorDataEntrada(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataEntrada) {
        return ResponseEntity.ok(animalService.buscarPorDataEntrada(dataEntrada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@PathVariable String id, @RequestBody @Valid Animal animal) {
        return ResponseEntity.ok(animalService.atualizar(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable String id) {
        return ResponseEntity.ok(animalService.deletar(id));
    }
}