package com.revature.ecommerce.interfaces;

import com.revature.ecommerce.entities.CartItem;
import com.revature.ecommerce.entities.Product;

import java.util.List;

public interface CartItemServiceInterface {

    CartItem addToCartService(CartItem cartItem);

    List<CartItem> getGetItems();

    boolean removeFromCart(Long id);
}
