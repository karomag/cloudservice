package com.example.cloudservice.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Login {
    @JsonProperty("auth-token")
    private final String authToken;
}
