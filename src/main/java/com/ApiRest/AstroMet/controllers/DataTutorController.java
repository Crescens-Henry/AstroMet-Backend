package com.ApiRest.AstroMet.controllers;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateDataTutorRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.services.interfaces.IDataTutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dataTutor")
public class DataTutorController {

    @Autowired
    private IDataTutorService service;
    @GetMapping
    public ResponseEntity<BaseResponse> list() {
        BaseResponse baseResponse = service.list();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping(value = "register")
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateDataTutorRequest request) {
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
