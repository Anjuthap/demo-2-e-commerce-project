package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CartDTO;

public interface CartService {

    CartDTO addProductToCart(Long cartId, Long productId, Integer quantity); //this method will return the cartdto objects which contain the info about cart when product is added

    List<CartDTO> getAllCarts();

    CartDTO getCart(String emailId, Long cartId);

    CartDTO updateProductQuantityInCart(Long cartId, Long productId, Integer quantity);

    void updateProductInCarts(Long cartId, Long productId);

    String deleteProductFromCart(Long cartId, Long productId);

}