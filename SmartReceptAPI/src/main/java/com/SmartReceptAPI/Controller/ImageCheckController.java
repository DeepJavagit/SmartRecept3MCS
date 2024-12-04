package com.SmartReceptAPI.Controller;

import com.SmartReceptAPI.entity.Image;
import com.SmartReceptAPI.repo.ImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/images-check")
public class ImageCheckController {

    private final Path rootLocation = Paths.get("uploads");
    private final ImageRepository imageRepository;

    public ImageCheckController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/upload-check")
    public ResponseEntity<String> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("coustmerReceptId") Long coustmerReceptId) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("No file uploaded");
            }

            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Path targetLocation = rootLocation.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation);

            Image image = new Image();
            image.setFileName(filename);
            image.setFilePath(targetLocation.toString());
            image.setContentType(file.getContentType());
            image.setCoustmerReceptId(coustmerReceptId);

            imageRepository.save(image);

            return ResponseEntity.ok("Image uploaded successfully with ID: " + image.getId());
        } catch (IOException ex) {
            return ResponseEntity.status(500).body("Failed to upload image: " + ex.getMessage());
        }
    }
}
