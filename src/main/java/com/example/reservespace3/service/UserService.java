package com.example.reservespace3.service;

import com.example.reservespace3.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname);
    void processOAuthPostLogin(String username);
}
