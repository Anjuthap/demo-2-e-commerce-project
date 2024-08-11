package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category createCategory = adminService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> allCategories = adminService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }
    @PostMapping("/product/{categoryId}")
    public ResponseEntity<Product> postProduct(@PathVariable Long categoryId, @ModelAttribute ProductDTO productDTO) throws Exception{
        Product postedProduct= adminService.postProduct(categoryId,productDTO);
return  ResponseEntity.status(HttpStatus.CREATED).body(postedProduct);
    }

}
