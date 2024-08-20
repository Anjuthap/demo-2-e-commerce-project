package com.example.demo.service;

import com.example.demo.dto.UserDTO;
//import com.example.demo.dto.UserResponse;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

//    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    UserDTO getUserById(Long userId);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    String deleteUser(Long userId);
}