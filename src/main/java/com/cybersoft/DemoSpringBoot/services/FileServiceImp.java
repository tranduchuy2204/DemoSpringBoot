package com.cybersoft.DemoSpringBoot.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

//@Beans, @Component
//@Service: Liên quan đến xử lý logic code
//@Repository: Liên quan tới kết nối database
@Service
public class FileServiceImp implements FileService {
    private final Path root = Paths.get("images");

    @Override
    public void init() {

        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (Exception e) {
            System.out.println("Error create root folder " + e.getMessage());
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        } catch (Exception e) {
            System.out.println("Error save file to root folder " + e.getMessage());
        }
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path file = this.root.resolve(fileName);

            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Error resource not exists");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error resource not exists " + e.getMessage());

        }

    }
}
