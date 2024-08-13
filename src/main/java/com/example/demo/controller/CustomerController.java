package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")

public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/product/search/{title}")
    public ResponseEntity<List<ProductDTO>> searchProductByTitle(@PathVariable String title){
        List<ProductDTO> productDTOList = customerService.searchProductByTitle(title);
        return ResponseEntity.ok(productDTOList);
    }
}
