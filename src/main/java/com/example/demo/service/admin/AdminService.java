package com.example.demo.service.admin;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    Category createCategory(CategoryDTO categoryDTO);

    List<Category> getAllCategories();

    Product postProduct(Long categoryId, ProductDTO productDTO) throws IOException;
}
