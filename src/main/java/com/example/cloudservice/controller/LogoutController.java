package com.example.cloudservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping
    public ResponseEntity<String> logOut() {
        return ResponseEntity.ok().body("Success logout");
    }
}
