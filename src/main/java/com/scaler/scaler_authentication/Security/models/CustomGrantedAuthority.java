package com.scaler.scaler_authentication.Security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.scaler.scaler_authentication.model.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@JsonDeserialize
@NoArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority {
    private String authority;
    public CustomGrantedAuthority(Role role) {
        this.authority=role.getName();
    }

    @Override
    public String getAuthority() {
        //return role.getName();
        return this.authority;
    }
}
