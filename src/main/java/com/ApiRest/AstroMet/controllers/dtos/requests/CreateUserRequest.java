package com.ApiRest.AstroMet.controllers.dtos.requests;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class CreateUserRequest {
    @NotNull @NotBlank
    private String name;
    @NotNull @NotBlank
    private String lastName;
    @NotNull @NotBlank
    private String password;
    @NotNull @NotBlank
    private String phoneNumber;
    @Min(value = 7, message = "Age must be greater than or equal to 7")
    private Integer age;
    @NotNull @NotBlank
    private String email;
    private String educationLevel;
    @NotNull @NotBlank
    private String address;
    @NotNull @NotBlank
    private String regionOrState;

    private String nameTutor;
    private String lastNameTutor;
    private String phoneNumberTutor;
    private String emailTutor;
}
