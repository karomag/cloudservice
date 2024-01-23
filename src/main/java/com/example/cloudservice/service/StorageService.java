package com.example.cloudservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file);

    void deleteAll();

    Map<String, Integer> loadAll();
}
