package com.example.cloudservice.service;

import com.example.cloudservice.dto.AuthTokenDto;

public interface AuthTokenService {

    AuthTokenDto generateToken();
}
