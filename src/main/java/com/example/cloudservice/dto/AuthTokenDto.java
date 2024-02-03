package com.example.cloudservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthTokenDto {
    @JsonProperty("auth-token")
    private final String authToken;
    private final String email;
}
