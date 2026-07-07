package com.taskflow.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.application.entities.Tarefa;
import com.taskflow.application.entities.enums.StatusTarefa;
import com.taskflow.application.repositories.TarefaRepository;
import com.taskflow.application.services.exception.EntityNotFound;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa create (Tarefa obj){
        return repository.save(obj);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public Tarefa getId (Long id){
        Optional<Tarefa> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new EntityNotFound("Tarefa de " + id + "não encontrada!");
        }
        return obj.get();
    }

    public List<Tarefa> getAll(){
        return repository.findAll();
    }

    public Tarefa update(Tarefa obj){
        Optional<Tarefa> newObj = repository.findById(obj.getId());
        if(newObj.isEmpty()){
            throw new EntityNotFound("Tarefa de id" + obj.getId() + "não encontrada!");
        }
        updateTarefa(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateTarefa(Optional<Tarefa> newObj, Tarefa obj){
        newObj.get().setTitulo(obj.getTitulo());
        newObj.get().setDescricao(obj.getDescricao());
        newObj.get().setStatus(obj.getStatus());
        newObj.get().setPrioridade(obj.getPrioridade());

        if(obj.getStatus() == StatusTarefa.CONCLUIDA && 
            newObj.get().getConcluidoEm() == null){
        obj.setConcluidoEm(LocalDateTime.now());
    }
    

    
}
