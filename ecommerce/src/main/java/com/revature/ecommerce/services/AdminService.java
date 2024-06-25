package com.revature.ecommerce.services;

import com.revature.ecommerce.entities.Product;
import com.revature.ecommerce.entities.User;
import com.revature.ecommerce.enumerations.UserStatus;
import com.revature.ecommerce.interfaces.AdminServiceInterface;
import com.revature.ecommerce.repositories.ProductRepository;
import com.revature.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Product createProductService(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product retrievedProductService(long id) {
        Optional<Product> optionalProduct =  this.productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product editProductService(Long id, Product prod) {
        Optional<Product> optionalProduct =  this.productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProductPrice(prod.getProductPrice());
            return this.productRepository.save(product);
        }
        return null;
    }

    @Override
    public List<Product> getAllProductService() {
        return productRepository.findAll();
    }

    @Override
    public boolean deleteProductService(long id) {
        productRepository.deleteById(id);
        return productRepository.existsById(id);
    }
}
