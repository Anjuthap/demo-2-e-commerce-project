package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<CategoryDTO> getAllCategories(){
       return  categoryRepository.findAll().stream().map(Category::getCategoryDto).collect(Collectors.toList()); //findall function is used to retrieve all the instances from database

    }
    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }

    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            return categoryRepository.save(category);
        }
        return null;
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
            product.setQuantity(productDTO.getQuantity());
            product.setDiscount(productDTO.getDiscount());
            product.setImage(productDTO.getImage().getBytes());
            product.setCategory(optionalCategory.get());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public UserDTO getAllProducts() {
        return (UserDTO) productRepository.findAll().stream().map(Product::getProductDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
         Optional<Product> optionalProduct= productRepository.findById(id);
         if (optionalProduct.isEmpty())
             throw  new IllegalArgumentException("Product with id" + id + "not found");
         productRepository.deleteById(id);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> optionalProduct= productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product.getProductDTO();
        }
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long categoryId, Long productId, ProductDTO productDTO) throws IOException {
       Optional<Category> optionalCategory= categoryRepository.findById(categoryId);
      Optional<Product> optionalProduct=  productRepository.findById(productId);
      if(optionalCategory.isPresent() && optionalProduct.isPresent()){
          Product product= optionalProduct.get();
          product.setName(productDTO.getName());
          product.setDescription(productDTO.getDescription());
          product.setPrice(productDTO.getPrice());
          product.setCategory(optionalCategory.get());
          if (productDTO.getImage() !=null)
              product.setImage(productDTO.getImage().getBytes());
          Product updatedProduct=productRepository.save(product);
          ProductDTO updatedProductDTO = new ProductDTO();
      updatedProductDTO.setId(updatedProduct.getId());
      return updatedProductDTO;
      }
        return null;
    }


}
