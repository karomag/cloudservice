package com.example.cloudservice.service;

import com.example.cloudservice.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StorageService {

    void init();

    void store(MultipartFile file) throws IOException;

    List<FileEntity> loadFiles(int limit);

    FileEntity downloadFile(String filename);

    void deleteFile(String filename);

    void deleteAll();

}
