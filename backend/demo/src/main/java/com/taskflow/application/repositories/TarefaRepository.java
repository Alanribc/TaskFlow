package com.taskflow.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskflow.application.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}
