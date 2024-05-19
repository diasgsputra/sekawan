package com.sekawan.sekawan.controller;

import com.sekawan.sekawan.entity.User;
import com.sekawan.sekawan.repository.UserRepository;
import com.sekawan.sekawan.request.UserRequest;
import com.sekawan.sekawan.service.FileStorageService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FileStorageService fileStorageService;

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest
  ) throws IOException {
    User user = new User(userRequest);
    userRepository.save(user);
    return ResponseEntity.ok("User created succesfully");
  }

  @PutMapping("/upload/{id}")
  public ResponseEntity<String> createUser(@PathVariable Long id,
                                           @RequestParam("document") MultipartFile document,
                                           @RequestParam("video") MultipartFile video,
                                           @RequestParam("image") MultipartFile image) throws IOException {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

    if (document != null && !document.isEmpty()) {
      String documentPath = fileStorageService.saveFile(document);
      user.setDocument(documentPath);
    }
    if (video != null && !video.isEmpty()) {
      String videoPath = fileStorageService.saveFile(video);
      user.setVideo(videoPath);
    }
    if (image != null && !image.isEmpty()) {
      String imagePath = fileStorageService.saveFile(image);
      user.setImage(imagePath);
    }

    userRepository.save(user);
    return ResponseEntity.ok("File uploaded succesfully");
  }


  @GetMapping
  public ResponseEntity<List<User>> getAllUser() {
    List<User> users = userRepository.findAll();
    if (users.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(users);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(@PathVariable Long id,
                                         @RequestBody UserRequest userRequest) throws IOException {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    // Update only the fields that have changed
    if (userRequest.getUsername() != null) {
      user.setUsername(userRequest.getUsername());
    }
    if (userRequest.getEmail() != null) {
      user.setEmail(userRequest.getEmail());
    }
    if (userRequest.getName() != null) {
      user.setName(userRequest.getName());
    }
    if (userRequest.getPhone() != null) {
      user.setPhone(userRequest.getPhone());
    }
    if (userRequest.getAddress() != null) {
      user.setAddress(userRequest.getAddress());
    }
    if (userRequest.getGender() != null) {
      user.setGender(userRequest.getGender());
    }
    if (userRequest.getOccupation() != null) {
      user.setOccupation(userRequest.getOccupation());
    }
    if (userRequest.getStatus() != null) {
      user.setStatus(userRequest.getStatus());
    }
    if (userRequest.getCitizen() != null) {
      user.setCitizen(userRequest.getCitizen());
    }

    userRepository.save(user);
    return ResponseEntity.ok("Updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    if (userRepository.existsById(id)) {
      userRepository.deleteById(id);
      return ResponseEntity.ok("Deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

