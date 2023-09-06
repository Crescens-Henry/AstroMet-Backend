package com.ApiRest.AstroMet.services.interfaces;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateUserRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.entities.User;

public interface IUserService {
    BaseResponse get(String email);

    BaseResponse create(CreateUserRequest request);

    void delete(long id);

    User getUserByName(String username);
}

