package com.example.cloudservice.service;

import com.example.cloudservice.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {

    void init();

    void store(MultipartFile file);

    List<FileEntity> loadFiles(int limit);

    void deleteAll();

}
