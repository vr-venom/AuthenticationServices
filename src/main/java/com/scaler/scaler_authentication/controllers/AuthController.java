package com.scaler.scaler_authentication.controllers;



import com.scaler.scaler_authentication.dtos.*;
import com.scaler.scaler_authentication.exception.UserAlreadyExistsException;
import com.scaler.scaler_authentication.exception.UserDoesNotExistException;
import com.scaler.scaler_authentication.model.SessionStatus;
import com.scaler.scaler_authentication.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto request) throws UserDoesNotExistException {
        return authService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request) {
        return authService.logout(request.getToken(), request.getUserId());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto request) throws UserAlreadyExistsException {
        UserDto userDto = authService.signUp(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateTokenResponseDtos> validateToken(@RequestBody ValidateTokenRequestDto request) {
        Optional<UserDto> userDto = authService.validate(request.getToken(), request.getUserId());
        if(userDto.isEmpty()){
            ValidateTokenResponseDtos response = new ValidateTokenResponseDtos();
            response.setSessionStatus(SessionStatus.INVALID);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ValidateTokenResponseDtos response = new ValidateTokenResponseDtos();
        response.setSessionStatus(SessionStatus.ACTIVE);
        response.setUserDto(userDto.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
