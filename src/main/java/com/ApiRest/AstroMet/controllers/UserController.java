package com.ApiRest.AstroMet.controllers;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateUserRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.services.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<BaseResponse> list() {
        BaseResponse baseResponse = service.list();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
    @RequestMapping(value = "findByName", params = "name")
    public ResponseEntity<BaseResponse> get(@RequestParam String name) {
        BaseResponse baseResponse = service.getUserByName(name);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
    @PostMapping(value = "register")
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateUserRequest request) {
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
