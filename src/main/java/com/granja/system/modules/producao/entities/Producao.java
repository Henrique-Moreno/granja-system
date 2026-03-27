package com.granja.system.modules.producao.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@Document(collection = "producoes")
public class Producao {

    @Id
    private String id;

    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "Quantidade de ovos é obrigatória")
    @Min(value = 0, message = "Quantidade não pode ser negativa")
    private Integer quantidadeOvos;

    @NotNull(message = "ID do animal é obrigatório")
    private String idAnimal;
}