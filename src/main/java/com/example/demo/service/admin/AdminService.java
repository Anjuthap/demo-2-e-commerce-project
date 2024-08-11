package com.example.demo.service.admin;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;

import java.util.List;

public interface AdminService {
    Category createCategory(CategoryDTO categoryDTO);

    List<Category> getAllCategories();
}
