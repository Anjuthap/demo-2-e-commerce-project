package com.example.demo.service.customer;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;

import java.util.List;

public interface CustomerService {

    List<ProductDTO> searchProductByTitle(String title);


}
