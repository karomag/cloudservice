package com.example.cloudservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginDto {
    @JsonProperty("auth-token")
    private final String authToken;
    private final String login;
    private final String password;
}
