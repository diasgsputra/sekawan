package com.sekawan.sekawan.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService{
  private final Path rootLocation = Paths.get("file");

  public FileStorageServiceImpl() {
    try {
      Files.createDirectories(rootLocation);
    } catch (IOException e) {
      throw new RuntimeException("Could not create storage directory!", e);
    }
  }

  public String saveFile(MultipartFile file) throws IOException {
    if (file.isEmpty()) {
      throw new RuntimeException("Failed to store empty file.");
    }
    Path destinationFile = rootLocation.resolve(
            Paths.get(file.getOriginalFilename()))
        .normalize().toAbsolutePath();
    file.transferTo(destinationFile);
    return destinationFile.toString();
  }
}
