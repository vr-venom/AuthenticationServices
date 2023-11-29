package com.scaler.scaler_authentication.Security.repositories;

import java.util.Optional;

import com.scaler.scaler_authentication.Security.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}
