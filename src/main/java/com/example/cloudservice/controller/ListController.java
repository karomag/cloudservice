package com.example.cloudservice.controller;

import com.example.cloudservice.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/list")
public class ListController {

    private final StorageService storageService;

    @GetMapping()
    public ResponseEntity<?> getList(@RequestParam int limit) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(storageService.loadFiles(limit));
    }
}
