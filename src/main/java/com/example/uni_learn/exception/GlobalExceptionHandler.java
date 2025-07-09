package com.example.uni_learn.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadable(HttpMessageNotReadableException ex){
        String msg = "Некорректный формат запроса: " + ex.getMostSpecificCause().getMessage();
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, msg);
        return ResponseEntity.badRequest().body(error);
    }
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getFieldErrors()
        .stream().map(e -> e.getField() + ": " + e.getDefaultMessage()).toList();
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, "Ошибка валидации", errors);
        return ResponseEntity.badRequest().body(error); 
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex){
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
