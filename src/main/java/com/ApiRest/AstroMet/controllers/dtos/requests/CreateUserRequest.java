package com.ApiRest.AstroMet.controllers.dtos.requests;
import lombok.*;

@Getter
@Setter
public class CreateUserRequest {
    private String name;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Integer age;
    private String email;
    private String educationLevel;
    private String address;
    private String regionOrState;
}
