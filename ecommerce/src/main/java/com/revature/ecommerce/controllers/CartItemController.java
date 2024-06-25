package com.revature.ecommerce.controllers;

import com.revature.ecommerce.entities.CartItem;
import com.revature.ecommerce.interfaces.CartItemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    @Autowired
    private CartItemServiceInterface cartItemServiceInterface;


    @GetMapping
    public List<CartItem> getItemsHandler() {
        return cartItemServiceInterface.getGetItems();
    }

}
