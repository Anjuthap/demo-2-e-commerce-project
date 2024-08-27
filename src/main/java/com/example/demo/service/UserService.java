package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserResponse;
import com.example.demo.entities.User;

import java.util.List;
//import com.example.demo.dto.UserResponse;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

//    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    UserDTO getUserById(Long userId);

    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);


// UserDTO updateUser(Long userId, UserDTO userDTO);
//    String deleteUser(Long userId);
//     UserDTO getAllProducts(UserDTO userDTO);

}