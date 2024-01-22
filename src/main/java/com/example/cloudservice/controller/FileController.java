package com.example.cloudservice.controller;

import com.example.cloudservice.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {

    private final StorageService storageService;

    @PostMapping()
    public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file) {
        storageService.store(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
