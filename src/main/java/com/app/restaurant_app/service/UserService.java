package com.app.restaurant_app.service;

import com.app.restaurant_app.Exception.UserException;
import com.app.restaurant_app.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserProfileByJwt(String jwt) throws UserException;

    User findUserByEmail(String username) throws UserException;
}
