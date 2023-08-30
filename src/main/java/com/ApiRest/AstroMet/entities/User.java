package com.ApiRest.AstroMet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    private String password;
    private String phoneNumber;
    private Integer age;
    @Column(nullable = false)
    private String email;
    private String educationLevel;
    private String address;
    private String regionOrState;
}
