package com.example.demo.service.admin;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired //inject gareko
    private ProductRepository productRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO){
        Category category=new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return categoryRepository.save(category);

    }
    @Override
    public List<Category> getAllCategories(){
       return  categoryRepository.findAll(); //findall function is used to retrieve all the instances from database

    }
@Override
     //creating method
    public Product postProduct(Long categoryId, ProductDTO productDTO) throws IOException {
        Optional<Category> optionalCategory= categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()){
            Product product=new Product();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setImage(productDTO.getImage().getBytes());
            product.setCategory(optionalCategory.get());
            return productRepository.save(product);
        }
        return null;
    }
 }
