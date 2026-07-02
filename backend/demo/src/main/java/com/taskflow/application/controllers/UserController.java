package com.taskflow.application.controllers;

import com.taskflow.application.repositories.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.application.entities.User;
import com.taskflow.application.services.UserService;

@RestController
@RequestMapping(value= "/user")
public class UserController {
 
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getId(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }

}
