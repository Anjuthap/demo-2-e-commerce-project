package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; //custom JPQL query.
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cart;

@Repository //alows spring to recognze it as a bean for dependency injection
public interface CartRepo extends JpaRepository<Cart, Long>  //jparepo provides related methods for CRUD operations like save(), findById(), findAll(), deleteById()on Cart entities..
{
    @Query("SELECT c FROM Cart c WHERE c.user.email = ?1 AND c.id = ?2") //here cart entities is selected  where user email matches the given email and cart id match tw provided cart id
    Cart findCartByEmailAndCartId(String email, Long cartId); //method

//    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems ci JOIN FETCH ci.product p WHERE p.id = ?1")
//    List<Cart> findCartsByProductId(Long productId); //The method returns a list of Cart objects that contain the product with the given productId
}