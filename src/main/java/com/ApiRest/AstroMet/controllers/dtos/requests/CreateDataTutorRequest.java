package com.ApiRest.AstroMet.controllers.dtos.requests;
import lombok.*;

@Getter
@Setter
public class CreateDataTutorRequest {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Long clientId;
}
