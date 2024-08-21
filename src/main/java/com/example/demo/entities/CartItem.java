package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //maps a table in a db
@Table(name = "cart_items")
@Data //boilerplate methos generate gardincha like save(),
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generate ID OF the Pk IN DB
    private Long cartItemId;

    @ManyToOne // many CartItem entities can be associated with one Cart.
    @JoinColumn(name = "cart_id") //create cart id column in cart item table that contains Cart entities.
    private Cart cart;

    @ManyToOne //many CartItem entities can be associated with one Product
    @JoinColumn(name = "product_id")
    private Product product;

//    private Integer quantity;
    private double discount;
    private double productPrice;

}