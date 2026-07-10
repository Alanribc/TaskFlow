package com.taskflow.application.controllers.exception;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    
    private Instant timestamp;

    private Integer status;
    
    private String error;

    private String message;

    private String path;
}
