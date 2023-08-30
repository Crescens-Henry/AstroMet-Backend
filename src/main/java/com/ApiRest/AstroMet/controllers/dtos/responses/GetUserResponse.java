package com.ApiRest.AstroMet.controllers.dtos.responses;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
public class GetUserResponse {
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String password;
    private String phoneNumber;
    private Integer age;
    private String email;
    private String educationLevel;
    private String address;
    private String regionOrState;
}
