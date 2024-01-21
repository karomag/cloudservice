package com.example.cloudservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/list")
public class ListController {

    @GetMapping
    public void getList() {

    }
}
