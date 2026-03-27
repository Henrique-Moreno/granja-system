package com.granja.system.modules.venda.controller;

import com.granja.system.modules.venda.entities.Venda;
import com.granja.system.modules.venda.service.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> registrar(@RequestBody @Valid Venda venda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.registrar(venda));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarTodas() {
        return ResponseEntity.ok(vendaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(vendaService.buscarPorId(id));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Venda>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(vendaService.buscarPorTipo(tipo));
    }

    @GetMapping("/data/{data}")
    public ResponseEntity<List<Venda>> buscarPorData(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(vendaService.buscarPorData(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable String id, @RequestBody @Valid Venda venda) {
        return ResponseEntity.ok(vendaService.atualizar(id, venda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}