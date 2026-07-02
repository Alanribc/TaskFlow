package com.taskflow.application.entities;

import java.io.Serializable;

import com.taskflow.application.entities.enums.PrioridadeTarefa;
import com.taskflow.application.entities.enums.StatusTarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo; 

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @Enumerated(EnumType.STRING)
    private PrioridadeTarefa prioridade;

    private String descricao;
}
