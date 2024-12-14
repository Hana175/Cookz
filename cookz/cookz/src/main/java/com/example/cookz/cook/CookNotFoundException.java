package com.example.cookz.cook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CookNotFoundException extends RuntimeException{
    public CookNotFoundException(){
        super("Cook not found");
    }
}
