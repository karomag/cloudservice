package com.example.cloudservice.service;

import com.example.cloudservice.repository.FileRepository;
import com.example.cloudservice.entity.FileEntity;
import com.example.cloudservice.schemas.StorageException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class FileStorageService implements StorageService{

    private final FileRepository fileRepository;

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            FileEntity uploadedFile = new FileEntity();
            uploadedFile.setFile(file.getBytes());
            uploadedFile.setFilename(file.getOriginalFilename());
            uploadedFile.setSize(file.getSize());
            fileRepository.save(uploadedFile);
        } catch (IOException e) {
            throw new StorageException("Error input data", e);
        }
    }

    @Override
    public List<FileEntity> loadFiles(int limit) {
        PageRequest page = PageRequest.of(0, limit);
        return fileRepository.findAll(page).getContent();
    }

    @Override
    public void deleteAll() {

    }

}
