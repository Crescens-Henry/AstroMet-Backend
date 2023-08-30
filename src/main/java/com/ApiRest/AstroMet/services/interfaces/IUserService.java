package com.ApiRest.AstroMet.services.interfaces;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateDataTutorRequest;
import com.ApiRest.AstroMet.controllers.dtos.requests.CreateUserRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.entities.User;

public interface IUserService {
    BaseResponse list();
    BaseResponse get(Long id);

    User findUserById(Long id);

    //Obtengo a el usuario por medio del nombre esto repercute en el repositorio en la busqueda de email
    BaseResponse getUserByName(String name);

    BaseResponse create(CreateUserRequest request);
}
