package com.example.cloudservice;

import com.example.cloudservice.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
//			storageService.deleteAll();
//			storageService.init();
		};
	}
}
