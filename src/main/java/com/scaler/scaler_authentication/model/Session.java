package com.scaler.scaler_authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Session extends BaseModel{
    private String token;
    @ManyToOne
    private User user;
}
