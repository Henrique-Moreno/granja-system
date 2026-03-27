package com.granja.system.modules.venda.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@Document(collection = "vendas")
public class Venda {

    @Id
    private String id;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo; // animal ou ovo

    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "Valor é obrigatório")
    @Min(value = 0, message = "Valor não pode ser negativo")
    private Double valor;

    private String idAnimal;
}