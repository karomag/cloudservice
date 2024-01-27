package com.example.cloudservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDto {
    @JsonProperty("auth-token")
    private final String authToken;
}
