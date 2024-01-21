package com.example.cloudservice.schemas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    //Error message
    private String message;
    private int id;
}
