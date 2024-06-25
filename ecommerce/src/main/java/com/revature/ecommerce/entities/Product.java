package com.revature.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private float productPrice;
    @Column(nullable = false)
    private String productDescription;
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public Product(String productName, float productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }
}
