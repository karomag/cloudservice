package com.example.cloudservice.service;

import com.example.cloudservice.schemas.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService{

    @Value("${storage.location}")
    private String location;

    @Override
    public void init() {
        try {
            Files.createDirectories(Paths.get(location));
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = Paths.get(location).resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(Paths.get(location).toFile());
    }

    @Override
//    public Stream<Path> loadAll() {
//        try {
//            Path rootLocation = Paths.get(location);
//            return Files.walk(rootLocation, 1)
//                    .filter(path -> !path.equals(rootLocation))
//                    .map(rootLocation::relativize);
//        } catch (IOException e) {
//            throw new StorageException("Failed to read stored files", e);
//        }
//    }
    public Map<String, Integer> loadAll() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            File[] files = new File(location).listFiles();
            for (File file:files) {
                map.put(file.getName(), (int) file.length());
            }
        } catch (RuntimeException e) {
            throw new StorageException("Failed to read stored files", e);
        }
        return map;
    }
}
