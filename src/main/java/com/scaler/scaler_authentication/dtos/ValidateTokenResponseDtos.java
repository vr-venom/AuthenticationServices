package com.scaler.scaler_authentication.dtos;

import com.scaler.scaler_authentication.model.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDtos {
    private UserDto userDto;
    private SessionStatus sessionStatus;

}
