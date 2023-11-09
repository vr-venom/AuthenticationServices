package com.scaler.scaler_authentication.services;

import com.scaler.scaler_authentication.exception.NotFoundException;
import com.scaler.scaler_authentication.model.User;

import java.util.Optional;

public interface AuthenticationService {
    String loginUser( String email, String password) throws NotFoundException;
    Optional<User> validate(String token) throws NotFoundException;

}
