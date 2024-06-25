package com.revature.ecommerce.interfaces;


import com.revature.ecommerce.entities.Product;
import com.revature.ecommerce.entities.User;
import com.revature.ecommerce.enumerations.UserStatus;

public interface UserServiceInterface {

    User createProfileService(User user);

    User getProfileService(String id);

    User loginUserService(String email, String password);

    User editProfileService(String id, String password);

    boolean deleteProfileService(String id);

    boolean blockUser(String id, UserStatus userStatus);

}
