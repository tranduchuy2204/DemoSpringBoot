package com.cybersoft.DemoSpringBoot.controller;

import com.cybersoft.DemoSpringBoot.services.FileService;
import com.cybersoft.DemoSpringBoot.services.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> upLoadFiles(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.init();
        fileService.save(file);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping(value = "/show-file/{name}", produces = "image/png")
    public byte[] showImage(@PathVariable("name") String name) throws IOException {
        return Files.readAllBytes(Paths.get("images/" + name));
    }

    @GetMapping(value = "/{filename}", produces = "image/png")
    public ResponseEntity<?> loadFile(
            @PathVariable("filename") String fileName) {
        Resource resource = fileService.load(fileName);
        return ResponseEntity
                .ok()
                .contentType(MediaType.ALL)
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=\"%s\"", resource.getFilename())
                ).body(resource);
    }
}
