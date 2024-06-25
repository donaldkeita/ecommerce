package com.revature.ecommerce.controllers;

import com.revature.ecommerce.entities.CartItem;
import com.revature.ecommerce.entities.User;
import com.revature.ecommerce.interfaces.CartItemServiceInterface;
import com.revature.ecommerce.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    private CartItemServiceInterface cartItemServiceInterface;

    @PostMapping("/create-account")
    public User createProfileHandler(@RequestBody User user) {
        return userServiceInterface.createProfileService(user);
    }

    @PostMapping("/login")
    public User loginUserHandler(@RequestBody User user)  {
        return userServiceInterface.loginUserService(user.getEmail(), user.getPassword());
    }

    @DeleteMapping("/delete-profile/{id}")
    public boolean deleteProfileHandler(@PathVariable String id) {
        return userServiceInterface.deleteProfileService(id);
    }

    @GetMapping("/view-profile/{id}")
    public User getProfileHandler(@PathVariable String id) {
        return userServiceInterface.getProfileService(id);
    }

    @PatchMapping("/edit-profile/{id}")
    public User editProfileHandler(@PathVariable String id, @RequestBody User user) {
        return userServiceInterface.editProfileService(id, user.getPassword());
    }


    @PostMapping("/add-to-cart")
    public CartItem addToCartHandler(@RequestBody CartItem cartItem) {
        return cartItemServiceInterface.addToCartService(cartItem);
    }

    @DeleteMapping("/checkout/{id}")
    public boolean removeFromCartHandler(@PathVariable Long id) {
        return cartItemServiceInterface.removeFromCart(id);
    }
}
