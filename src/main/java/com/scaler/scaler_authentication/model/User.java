package com.scaler.scaler_authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)    // EAGER: fetch all the roles of the user
    private Set<Role> roles= new HashSet();

}
