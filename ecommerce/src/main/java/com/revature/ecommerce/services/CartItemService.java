package com.revature.ecommerce.services;

import com.revature.ecommerce.entities.CartItem;
import com.revature.ecommerce.entities.Product;
import com.revature.ecommerce.interfaces.CartItemServiceInterface;
import com.revature.ecommerce.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements CartItemServiceInterface {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem addToCartService(CartItem cartItem) {
        return this.cartRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getGetItems() {
        return cartRepository.findAll();
    }

    @Override
    public boolean removeFromCart(Long id) {
        cartRepository.deleteById(id);
        return cartRepository.existsById(id);
    }
}
