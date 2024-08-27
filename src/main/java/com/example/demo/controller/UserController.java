package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UserResponse;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.example.demo.config.AppConstants;

import com.example.demo.dto.UserDTO;

//import com.app.payloads.UserResponse;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
//create user
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO registeredUser = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
//read user
    @GetMapping("/public/users/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        UserDTO user = userService.getUserById(userId);

        return new ResponseEntity<UserDTO>(user, HttpStatus.FOUND);
    }

//    @GetMapping("/public/products")
//    public  ResponseEntity<UserDTO> getAllProducts() {
//        UserDTO userDTO = adminService.getAllProducts();
//        return ResponseEntity.ok(userDTO);
//    }

//    @PutMapping("/public/users/{userId}")
//    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long userId) {
//        UserDTO updatedUser = userService.updateUser(userId, userDTO);
//
//        return new ResponseEntity<UserDTO>(updatedUser, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/admin/users/{userId}")
//    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
//        String status = userService.deleteUser(userId);
//
//        return new ResponseEntity<String>(status, HttpStatus.OK);
//    }
}
