package com.example.cloudservice.controller;

import com.example.cloudservice.dto.ErrorDto;
import com.example.cloudservice.entity.FileEntity;
import com.example.cloudservice.exception.StorageException;
import com.example.cloudservice.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {

    private final StorageService storageService;

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorDto("Error input data"));
            }
            storageService.store(file);
        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDto("Error delet file"));
        }
        return ResponseEntity.ok().body("Success upload");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFile(@RequestParam("filename") String filename) {
        if (filename.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto("Error input data"));
        }
        try {
            storageService.deleteFile(filename);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDto("Error delet file"));
        }
        return ResponseEntity.ok().body("Success deleted");
    }

    @GetMapping
    public ResponseEntity<?> downloadFile(@RequestParam("filename") String filename) {
        if (filename.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto("Error input data"));
        }
        FileEntity fileEntity;
        try {
           fileEntity = storageService.downloadFile(filename);
        } catch (StorageException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDto("Error upload file"));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileEntity.getFilename())
                .body(fileEntity.getFile());
    }
}
