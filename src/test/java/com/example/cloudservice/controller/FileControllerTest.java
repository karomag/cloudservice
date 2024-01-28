package com.example.cloudservice.controller;

import com.example.cloudservice.entity.FileData;
import com.example.cloudservice.service.StorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FileControllerTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private FileController fileController;

    @Test
    void uploadFile_SuccessUpload() throws IOException {
        // given
        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",
                "test.txt",
                "text/plain",
                "Spring Framework".getBytes());
        // when
        ResponseEntity<String> responseEntity = this.fileController.uploadFile(multipartFile);
        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void deleteFile_SuccessDelete() {
        // given
        String filename = "test.txt";
        // when
        ResponseEntity<String> responseEntity = this.fileController.deleteFile(filename);
        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void downloadFile_SuccessDownload() throws FileNotFoundException {
        // given
        byte[] file = "Spring Framework".getBytes();
        String filename = "test.txt";
        FileData fileData = FileData.builder()
                .file(file)
                .size((long) file.length)
                .filename(filename).build();

        doReturn(fileData).when(this.storageService).downloadFile(filename);
        // when
        ResponseEntity<byte[]> responseEntity = this.fileController.downloadFile(filename);
        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(filename, responseEntity.getHeaders().getContentDisposition().getFilename());
        assertEquals(file, responseEntity.getBody());
    }

    @Test
    void updateFile_SuccessUpdate() throws FileNotFoundException {
        // given
        String filename = "test.txt";
        FileData fileData = FileData.builder()
                .filename("new_test.txt").build();
        // when
        ResponseEntity<String> responseEntity = this.fileController.updateFile(filename, fileData);
        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}