package com.revature.ecommerce.entities;
import com.revature.ecommerce.enumerations.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;
    @OneToMany(mappedBy = "user")
    private List<Product> products;

    public User(String name, String password, String email, UserStatus userStatus) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userStatus = userStatus;
    }
}
