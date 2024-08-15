package com.example.demo.dto;

import com.example.demo.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long orderItemId;
    private ProductDTO product;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;
}