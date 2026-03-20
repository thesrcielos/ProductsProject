package com.project.products.exception;

public class ProductException extends RuntimeException{
    private int code;
    public ProductException(String message, int code){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
