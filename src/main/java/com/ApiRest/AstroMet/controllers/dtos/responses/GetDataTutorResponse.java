package com.ApiRest.AstroMet.controllers.dtos.responses;
import lombok.*;

@Getter
@Setter
public class GetDataTutorResponse {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
}
