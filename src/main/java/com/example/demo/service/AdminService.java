package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    Category createCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategories();

    Product postProduct(Long categoryId, ProductDTO productDTO) throws IOException;

    List<ProductDTO> getAllProducts();

    void deleteProduct(Long id);

    ProductDTO getProductById(Long id);

    ProductDTO updateProduct(Long categoryId, Long productId, ProductDTO productDTO ) throws IOException;
}
