package com.ApiRest.AstroMet.controllers;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateUserRequest;
import com.ApiRest.AstroMet.controllers.dtos.requests.LoginRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.services.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private IUserService service;

    @RequestMapping(value = "findByName", params = "name")
    public ResponseEntity<BaseResponse> get(@RequestBody LoginRequest request) {
        return service.get(request.getName()).apply();
    }
    @PostMapping(value = "register")
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateUserRequest request) {
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
