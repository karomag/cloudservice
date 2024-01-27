package com.example.cloudservice.service;

import com.example.cloudservice.entity.FileEntity;
import com.example.cloudservice.exception.StorageException;
import com.example.cloudservice.repository.FileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class FileStorageService implements StorageService {

    private final FileRepository fileRepository;

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) throws IOException {
        FileEntity uploadedFile = new FileEntity();
        uploadedFile.setFile(file.getBytes());
        uploadedFile.setFilename(file.getOriginalFilename());
        uploadedFile.setSize(file.getSize());
        fileRepository.save(uploadedFile);
    }

    @Override
    public List<FileEntity> loadFiles(int limit) {
        PageRequest page = PageRequest.of(0, limit);
        return fileRepository.findAll(page).getContent();
    }

    @Override
    @Transactional
    public void deleteFile(String filename) {
        fileRepository.deleteByFilename(filename);
    }

    @Override
    @Transactional
    public FileEntity downloadFile(String filename) {
        Optional<FileEntity> optionalFile = fileRepository.getFileEntitiesByFilename(filename);
        if (!optionalFile.isPresent()) {
            throw new StorageException("File is not found.");
        }
        return optionalFile.get();
    }

    @Override
    public void deleteAll() {
        fileRepository.deleteAll();
    }

}
