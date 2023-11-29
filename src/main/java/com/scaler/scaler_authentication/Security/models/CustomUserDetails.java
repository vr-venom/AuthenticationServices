package com.scaler.scaler_authentication.Security.models;

import com.scaler.scaler_authentication.model.Role;
import com.scaler.scaler_authentication.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    User user;
    public CustomUserDetails(User user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<CustomeGrantedAuthority> customeGrantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            customeGrantedAuthorities.add(new CustomeGrantedAuthority(role));
        }
        return customeGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;// force user to change password after XX days
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
