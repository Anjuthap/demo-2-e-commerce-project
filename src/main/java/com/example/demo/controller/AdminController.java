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

import java.io.IOException;
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
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> allCategories = adminService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }
    @PostMapping("/product/{categoryId}")
    public ResponseEntity<Product> postProduct(@PathVariable Long categoryId, @ModelAttribute ProductDTO productDTO) throws Exception{ //modelattribute used to receive data in form rather than json body{
        Product postedProduct= adminService.postProduct(categoryId,productDTO);
    return  ResponseEntity.status(HttpStatus.CREATED).body(postedProduct);
    }
    @GetMapping("/products")
    public  ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOList = adminService.getAllProducts();
        return ResponseEntity.ok(productDTOList);
}

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        adminService.deleteProduct(id);
        return  ResponseEntity.noContent().build();

    }
    @GetMapping("/product/{id}") //Get product by ID
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
       ProductDTO productDTO = adminService.getProductById(id);
        if (productDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDTO);
    }
   @PutMapping("/{categoryId}/product/{productId}")
    public ResponseEntity<?> updateProduct(
        @PathVariable Long categoryId,
        @PathVariable Long productId,
        @ModelAttribute ProductDTO productDTO) throws IOException {
        ProductDTO updateProduct=adminService.updateProduct(categoryId,productId,productDTO);
        if (updateProduct == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        return ResponseEntity.ok(updateProduct);
    }
}
