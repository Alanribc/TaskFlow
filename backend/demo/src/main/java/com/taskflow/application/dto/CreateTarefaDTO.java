package com.taskflow.application.dto;

import java.time.LocalDateTime;

import com.taskflow.application.entities.enums.PrioridadeTarefa;
import com.taskflow.application.entities.enums.StatusTarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class CreateTarefaDTO {
    @NotBlank(message = "O título é obrigatório.")
    private String titulo;

    private String descricao;

    @NotNull(message = "A data e hora são obrigatórias.")
    private LocalDateTime dataHora;

    @NotNull(message = "O status é obrigatório.")
    private StatusTarefa status;

    @NotNull(message = "A prioridade é obrigatória.")
    private PrioridadeTarefa prioridade;

    @NotNull(message = "O usuário é obrigatório.")
    private Long userId;
}
