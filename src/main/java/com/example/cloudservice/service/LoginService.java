package com.example.cloudservice.service;

import com.example.cloudservice.dto.LoginDto;

public interface LoginService {

    LoginDto logIn(String login, String password);
}
