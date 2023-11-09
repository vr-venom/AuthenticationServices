package com.scaler.scaler_authentication.repositories;

import com.scaler.scaler_authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findUserByEmailAndPassword(String email, String password);
}
