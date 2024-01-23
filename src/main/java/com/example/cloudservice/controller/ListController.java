package com.example.cloudservice.controller;

import com.example.cloudservice.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/list")
public class ListController {

    private final StorageService storageService;

    @GetMapping
    public Map<String, Integer> getList() {
        return storageService.loadAll();
    }
}
