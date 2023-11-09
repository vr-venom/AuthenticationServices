package com.scaler.scaler_authentication.controllers;

import com.scaler.scaler_authentication.dtos.LoginDto;
import com.scaler.scaler_authentication.dtos.TokenDto;
import com.scaler.scaler_authentication.dtos.UserDto;
import com.scaler.scaler_authentication.exception.NotFoundException;
import com.scaler.scaler_authentication.model.User;
import com.scaler.scaler_authentication.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<TokenDto> Login(@RequestBody LoginDto loginDto)throws NotFoundException{
        String token = authenticationService.loginUser(loginDto.getEmail(), loginDto.getPassword());
        if(token == null) {
            throw new NotFoundException("No User with email: " + loginDto.getEmail());
        }
        ResponseEntity<TokenDto> response = ResponseEntity.ok(new TokenDto(token));

        return  response;
    }
    @PostMapping("/validate")
    public ResponseEntity<UserDto> validate(@RequestBody TokenDto tokenDto) throws NotFoundException{
        Optional<User> userOptional = authenticationService.validate(tokenDto.getToken());
        if(userOptional.isEmpty()){
            throw new NotFoundException("No User with token: " + tokenDto.getToken());
        }
        User user = userOptional.get();
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setPassword(null);
        ResponseEntity<UserDto> response = ResponseEntity.ok(userDto);  // 200 OK

        return response;
    }


}
