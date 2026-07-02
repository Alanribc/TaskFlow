package com.taskflow.application.services.exception;

public class EntityNotFound extends RuntimeException{
    
    
    public EntityNotFound(String msg){
        super(msg);
    }
}
