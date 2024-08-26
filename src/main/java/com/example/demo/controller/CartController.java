package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartDTO;
import com.example.demo.service.CartService;

//import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController //marks the class as a controller.its serve json data to the client...yo chai combine of controler and response body  so jasle auto json coversion gardincha
@RequestMapping("/api") //mapping
//@SecurityRequirement(name = "E-Commerce Application")
public class CartController {

    @Autowired
    private CartService cartService; //inject an instance of CartService into this controller, allowing it to use the business logic defined in the service layer.

    @PostMapping("/public/carts/{cartId}/products/{productId}/quantity/{quantity}")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId ,@PathVariable Integer quantity) { //Binds the method parameters to the respective path variables in the URL.
        CartDTO cartDTO = cartService.addProductToCart(cartId, productId, quantity); //Calls the service layer to add a product to the cart.

        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.CREATED);
    }

    @GetMapping("/admin/carts")
    public ResponseEntity<List<CartDTO>> getCarts() {

        List<CartDTO> cartDTOs = cartService.getAllCarts();

        return new ResponseEntity<List<CartDTO>>(cartDTOs, HttpStatus.FOUND);
    }

    @GetMapping("/public/users/{emailId}/carts/{cartId}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable String emailId, @PathVariable Long cartId) {
        CartDTO cartDTO = cartService.getCart(emailId, cartId);

        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.FOUND);
    }

    @PutMapping("/public/carts/{cartId}/products/{productId}/quantity/{quantity}")
    public ResponseEntity<CartDTO> updateCartProduct(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable Integer quantity) {
        CartDTO cartDTO = cartService.updateProductQuantityInCart(cartId, productId, quantity);

        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
    }

    @DeleteMapping("/public/carts/{cartId}/product/{productId}")
    public ResponseEntity<String> deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        String status = cartService.deleteProductFromCart(cartId, productId);

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}