package com.taskflow.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.application.dto.CreateTarefaDTO;
import com.taskflow.application.dto.TarefaDTO;
import com.taskflow.application.entities.Tarefa;
import com.taskflow.application.entities.User;
import com.taskflow.application.entities.enums.StatusTarefa;
import com.taskflow.application.repositories.TarefaRepository;
import com.taskflow.application.repositories.UserRepository;
import com.taskflow.application.services.exception.EntityNotFound;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    private UserRepository userRepository;

    public TarefaDTO toDTO(Tarefa tarefa){

        TarefaDTO dto = new TarefaDTO();

        dto.setId(tarefa.getId());
        dto.setTitulo(tarefa.getTitulo());
        dto.setDescricao(tarefa.getDescricao());
        dto.setDataHora(tarefa.getDataHora());
        dto.setStatus(tarefa.getStatus());
        dto.setPrioridade(tarefa.getPrioridade());
        dto.setCriadoEm(tarefa.getCriadoEm());
        dto.setAtualizadoEm(tarefa.getAtualizadoEm());
        dto.setConcluidoEm(tarefa.getConcluidoEm());

        return dto;
    }

    public Tarefa create (CreateTarefaDTO dto){
        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new EntityNotFound("Usuário não encontrado."));

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setDataHora(dto.getDataHora());
        tarefa.setStatus(dto.getStatus());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setUser(user);

        return repository.save(tarefa);
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

    
}


