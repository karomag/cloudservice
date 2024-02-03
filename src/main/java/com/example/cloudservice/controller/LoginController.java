package com.example.cloudservice.controller;

import com.example.cloudservice.dto.AuthTokenDto;
import com.example.cloudservice.service.AuthTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthTokenService authTokenService;

    @PostMapping
    public ResponseEntity<AuthTokenDto> logIn() {
        AuthTokenDto authTokenDto = authTokenService.generateToken();
        return ResponseEntity.status(HttpStatus.OK).body(authTokenDto);
    }

}
