package com.ApiRest.AstroMet.controllers.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Not found");
    }
}
