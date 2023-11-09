package com.scaler.scaler_authentication.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;

}