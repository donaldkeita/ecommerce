package com.revature.ecommerce.interfaces;

import com.revature.ecommerce.entities.Product;
import com.revature.ecommerce.enumerations.UserStatus;

import java.util.List;

public interface AdminServiceInterface {

    Product createProductService(Product product);

    Product editProductService(Long id, Product product);

    List<Product> getAllProductService();

    Product retrievedProductService(long id);

    boolean deleteProductService(long id);
}
