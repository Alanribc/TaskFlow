package com.taskflow.application.dto;

import java.time.LocalDateTime;


import com.taskflow.application.entities.enums.PrioridadeTarefa;
import com.taskflow.application.entities.enums.StatusTarefa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {
    
    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime dataHora;

    private StatusTarefa status;

    private PrioridadeTarefa prioridade;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;

    private LocalDateTime concluidoEm;
}
