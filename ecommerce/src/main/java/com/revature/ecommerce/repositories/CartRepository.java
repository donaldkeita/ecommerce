package com.revature.ecommerce.repositories;

import com.revature.ecommerce.entities.CartItem;
import com.revature.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
}
