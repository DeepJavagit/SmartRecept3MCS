package com.SmartReceptAPI.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    // Define the directory to save uploaded images
    
    private final Path rootLocation = Paths.get("uploads");

    public ImageController() {
        try {
            // Create the directory if it doesn't exist
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Ensure the file is not empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("No file uploaded");
            }

            // Get the original filename and build the target file path
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Path targetLocation = rootLocation.resolve(filename);

            // Copy the file to the target location
            Files.copy(file.getInputStream(), targetLocation);

            return ResponseEntity.ok("File uploaded successfully: " + filename);
        } catch (IOException ex) {
            return ResponseEntity.status(500).body("Failed to upload file: " + ex.getMessage());
        }
    }
}
