package com.project.products.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductException.class)
    public ErrorDetails handleProductException(ProductException ex){
        return new ErrorDetails(ex.getMessage(), ex.getCode(), LocalDateTime.now());
    }
}
