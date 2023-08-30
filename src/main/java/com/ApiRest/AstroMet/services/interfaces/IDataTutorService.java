package com.ApiRest.AstroMet.services.interfaces;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateDataTutorRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;

public interface IDataTutorService {
    BaseResponse list();
    BaseResponse get(Long id);

    BaseResponse create(CreateDataTutorRequest request);

}
