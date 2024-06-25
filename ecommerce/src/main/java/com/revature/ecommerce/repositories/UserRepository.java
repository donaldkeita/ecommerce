package com.revature.ecommerce.repositories;

import com.revature.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, String> {

    @Query("FROM User WHERE email = :emailVar and password = :passwordVar")
    User findByEmailAndPassword(@Param("emailVar")  String email, @Param("passwordVar") String password);
}
