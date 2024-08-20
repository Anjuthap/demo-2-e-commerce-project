package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor; //These imports are for Lombok annotations, which automatically generate boilerplate code like getters, setters, constructors, etc.
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Indicates that this class is a JPA entity. It is mapped to a table in the db.
@Data //lombok annotation ho jasle toString(), equals(), and hashCode() methods generate garcha.
@Table(name = "carts")
@NoArgsConstructor //lombok annotation used for no argument constructor..ie no parameter
@AllArgsConstructor // lombok annotation used for constructor having parameters
public class Cart {

    @Id //primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generate  id  of PK in db.
    private Long cartId; //Long store very large numbers...

    @OneToOne //a user can have only one shopping cart, and each shopping cart is associated with only one user.
    @JoinColumn(name = "user_id") //table that will be used to join with the user table..yo column le user entity reference lincha
    private User user;

    @OneToMany(mappedBy = "cart", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true) //one cart can have many cart items/cartitem ko entity mapp gareko ho ...it ensures that when you save or update the Order, the associated CartItem objects in the list are automatically saved or updated as well.
    private List<CartItem> cartItems = new ArrayList<>(); //orphan removal chai when we remove the cart item from cart items listthen  will be be deleted in the db...
//whenever new entities is added in the cart items field arraylist will grow dynamically..
    private Double totalPrice = 0.0;
}