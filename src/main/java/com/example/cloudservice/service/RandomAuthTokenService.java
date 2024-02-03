package com.example.cloudservice.service;

import com.example.cloudservice.dto.AuthTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RandomAuthTokenService implements AuthTokenService {

    @Override
    public AuthTokenDto generateToken() {
        UUID uuid = UUID.randomUUID();
        return new AuthTokenDto(uuid.toString(), "email");
    }
}
