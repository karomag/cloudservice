package com.example.cloudservice.controller;

import com.example.cloudservice.schemas.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Data
@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<Login> logIn() {
        Login login = new Login("123");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(login);
    }
}
