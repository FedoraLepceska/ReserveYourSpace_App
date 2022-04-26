package com.example.reservespace3.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    HOMEOWNER;

    @Override
    public String getAuthority() {
        return name();
    }
}
