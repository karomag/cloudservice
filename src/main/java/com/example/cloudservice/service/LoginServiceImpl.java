package com.example.cloudservice.service;

import com.example.cloudservice.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    @Override
    public LoginDto logIn(String login, String password) {
        UUID uuid = UUID.randomUUID();
        return new LoginDto(uuid.toString(), login, password);
    }
}
