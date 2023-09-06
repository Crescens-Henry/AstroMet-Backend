package com.ApiRest.AstroMet.controllers.dtos.requests;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter @Setter
public class LoginRequest {
    @NonNull
    private String name;
}