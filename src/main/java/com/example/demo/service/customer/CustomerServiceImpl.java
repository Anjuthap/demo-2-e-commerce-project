package com.example.demo.service.customer;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> searchProductByTitle(String title) {
        return ProductRepository.findAllByNameContaining(title).stream().map(Product::getProductDTO).collect(Collectors.toList());
    }
}
