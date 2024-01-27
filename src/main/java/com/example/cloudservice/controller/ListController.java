package com.example.cloudservice.controller;

import com.example.cloudservice.dto.ErrorDto;
import com.example.cloudservice.entity.FileEntity;
import com.example.cloudservice.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/list")
public class ListController {

    private final StorageService storageService;

    @GetMapping()
    public ResponseEntity<?> getAllFiles(@RequestParam int limit) {
        if (limit <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto("Error input data"));
        }
        List<FileEntity> files;
        try {
            files = storageService.loadFiles(limit);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDto("Error getting file list"));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(files);
    }
}
