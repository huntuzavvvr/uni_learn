package com.example.uni_learn.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;
    
    public ApiError(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
