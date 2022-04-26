package com.example.reservespace3.service;

import com.example.reservespace3.model.User;

public interface AuthService {
    User login(String username, String password);
}
