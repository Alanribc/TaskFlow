package com.taskflow.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.application.entities.User;
import com.taskflow.application.repositories.UserRepository;
import com.taskflow.application.services.exception.EntityNotFound;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create (User obj){
        return repository.save(obj);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public User getId (Long id){
        Optional<User> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new EntityNotFound("Usuário de " + id + "não encontrado!");
        }
        return obj.get();
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public User update(User obj){
        Optional<User> newObj = repository.findById(obj.getId());
        if(newObj.isEmpty()){
            throw new EntityNotFound("Usuário de id" + obj.getId() + "não encontrado!");
        }
        updateUser(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateUser(Optional<User> newObj, User obj){
        newObj.get().setNome(obj.getNome());
    }
}
