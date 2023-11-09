package com.scaler.scaler_authentication.services;

import com.scaler.scaler_authentication.exception.NotFoundException;
import com.scaler.scaler_authentication.model.Session;
import com.scaler.scaler_authentication.model.User;
import com.scaler.scaler_authentication.repositories.SessionRepository;
import com.scaler.scaler_authentication.repositories.UserRepository;
import com.scaler.scaler_authentication.util.RandomString;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    @Override
    public String loginUser(String email, String password) throws NotFoundException {
        Optional<User> user = userRepository.findUserByEmailAndPassword(email,password);
        if (user.isPresent()){
            throw new NotFoundException("No User with email: " + email);
        }
        String token = new RandomString(47,122).generate(20);
        Optional<Session> session = sessionRepository.findSessionByUserId(user.get().getId());
        if(session.isPresent()){
            sessionRepository.deleteById(user.get().getId());
        }
        Session newSession = sessionRepository.save(new Session(token,user.get()));

        return newSession.getToken();
    }

    @Override
    public Optional<User> validate(String token) throws NotFoundException {
        Optional<Session> session = sessionRepository.findByToken(token);
        if (session.isEmpty()){
            throw new NotFoundException("No User with token: " + token);
        }
        User user = session.get().getUser();
        return Optional.of(user);
    }
}
