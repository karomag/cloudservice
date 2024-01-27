package com.example.cloudservice.controller;

import com.example.cloudservice.dto.LoginDto;
import com.example.cloudservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginDto> logIn(@RequestBody LoginDto loginData) {
        var loginDto = loginService.logIn(loginData.getLogin(), loginData.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(loginDto);
    }
}
