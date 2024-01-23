package com.example.cloudservice.schemas;

import lombok.Data;

@Data

public class File {
    private String hash;
    private String file;
    private String filename;
    private int size;
}
