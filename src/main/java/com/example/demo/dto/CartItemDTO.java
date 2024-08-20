package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    private Long cartItemId; //field named cartItemId of type Long. This field represents the unique identifier for the CartItemDTO.
    private CartDTO cart; //cartdto ma vako objects cart item ma belong garcha
    private ProductDTO product;// products are belong parcha cartitems ma
    private Integer quantity; //product ko quantity k kati huncha when added to the cart
    private double discount; //product ko dis
    private double productPrice;
}