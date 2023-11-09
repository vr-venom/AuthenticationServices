package com.scaler.scaler_authentication.repositories;

import com.scaler.scaler_authentication.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session save(Session session);

    Optional<Session> findSessionByUserId(Long id);

    Optional<Session> findByToken(String token);
}
