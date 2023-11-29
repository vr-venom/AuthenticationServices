package com.scaler.scaler_authentication.Security.models;

import com.scaler.scaler_authentication.model.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomeGrantedAuthority implements GrantedAuthority {
    private Role role;
    public CustomeGrantedAuthority(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.getName();
    }
}
