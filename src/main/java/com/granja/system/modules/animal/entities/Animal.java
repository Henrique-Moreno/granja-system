package com.granja.system.modules.animal.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@Document(collection = "animais")
public class Animal {

    @Id
    private String id;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo; // galinha, galo, pintinho

    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 0, message = "Idade não pode ser negativa")
    private Integer idade;

    @NotNull(message = "Data de entrada é obrigatória")
    private LocalDate dataEntrada;
}
