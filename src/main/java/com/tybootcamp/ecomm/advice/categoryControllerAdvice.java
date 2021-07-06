package com.tybootcamp.ecomm.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class categoryControllerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound (EntityNotFoundException entityNotFoundException){
        return new ResponseEntity<>("Entity Not Found", HttpStatus.NOT_FOUND);
    }
}
