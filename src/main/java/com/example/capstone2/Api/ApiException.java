package com.example.capstone2.Api;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }

}
