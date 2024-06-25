package com.revature.ecommerce.services;


import com.revature.ecommerce.entities.User;
import com.revature.ecommerce.enumerations.UserStatus;
import com.revature.ecommerce.interfaces.UserServiceInterface;
import com.revature.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Override
    public User createProfileService(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getProfileService(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User loginUserService(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User editProfileService(String id, String password) {
        Optional<User> optionalUser =  this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(password);
            return this.userRepository.save(user);
        }
        return null;

    }

    @Override
    public boolean deleteProfileService(String id) {
        userRepository.deleteById(id);
        return userRepository.existsById(id);
    }

    @Override
    public boolean blockUser(String id, UserStatus userStatus) {
        Optional<User> optionalUser =  this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserStatus(userStatus);
            this.userRepository.save(user);
            return true;
        }
        return false;
    }


}
