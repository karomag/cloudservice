package com.example.cloudservice.controller;

import com.example.cloudservice.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Data
@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {
    private Login login;

    @PostMapping
    public Login successAuthorization() {
        login.setAuthToken("23123123123");
        return login;
    }
}
