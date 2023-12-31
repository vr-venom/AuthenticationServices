package com.scaler.scaler_authentication.dtos;

import com.scaler.scaler_authentication.model.Role;
import com.scaler.scaler_authentication.model.User;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter

public class UserDto {
    private String email;
    private Set<Role> roles = new HashSet<>();

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());

        return userDto;
    }
}
