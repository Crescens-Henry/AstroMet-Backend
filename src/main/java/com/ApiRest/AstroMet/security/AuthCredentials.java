package com.ApiRest.AstroMet.security;

import lombok.*;

@Getter
@Setter
public class AuthCredentials {
    private String name;
    private String password;
}
