package com.example.cloudservice.controller;

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
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping
    public ResponseEntity<?> logOut() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}