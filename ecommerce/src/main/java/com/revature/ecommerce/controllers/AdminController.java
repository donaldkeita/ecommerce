package com.revature.ecommerce.controllers;
import com.revature.ecommerce.entities.CartItem;
import com.revature.ecommerce.entities.Product;
import com.revature.ecommerce.entities.User;
import com.revature.ecommerce.interfaces.AdminServiceInterface;
import com.revature.ecommerce.interfaces.CartItemServiceInterface;
import com.revature.ecommerce.interfaces.UserServiceInterface;
import com.revature.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminServiceInterface adminServiceInterface;
    @Autowired
    private UserServiceInterface userServiceInterface;

    @PostMapping("/add-product")
    public Product createProductHandler(@RequestBody Product product) {
        return adminServiceInterface.createProductService(product);
    }

    @GetMapping("/product/{id}")
    public Product getProductHandler(Long id) {
        return adminServiceInterface.retrievedProductService(id);
    }

    @GetMapping("/viewAll")
    public List<Product> getAllListHandler(@PathVariable Long id){
        return adminServiceInterface.getAllProductService();
    }

    @PatchMapping("/edit-product/{id}")
    public Product editProductHandler(@PathVariable Long id, @RequestBody Product product) {
        return adminServiceInterface.editProductService(id, product);
    }

    @PatchMapping("/blockUser/{id}")
    public boolean blockUserHandler(@RequestBody User user) {
        return userServiceInterface.blockUser(user.getId(), user.getUserStatus());
    }
}
