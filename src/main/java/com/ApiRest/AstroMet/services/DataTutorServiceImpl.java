package com.ApiRest.AstroMet.services;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateDataTutorRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.controllers.dtos.responses.GetDataTutorResponse;
import com.ApiRest.AstroMet.entities.DataTutor;
import com.ApiRest.AstroMet.entities.User;
import com.ApiRest.AstroMet.repositories.IDataTutorRepository;
import com.ApiRest.AstroMet.services.interfaces.IDataTutorService;
import com.ApiRest.AstroMet.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataTutorServiceImpl implements IDataTutorService {

    @Autowired
    private IDataTutorRepository repository;

    @Override
    public BaseResponse list() {
        List<GetDataTutorResponse> response = repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("List of DataTutor have been obtained correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private GetDataTutorResponse from(DataTutor dataTutor){
        GetDataTutorResponse response = new GetDataTutorResponse();
        response.setId(dataTutor.getId());
        response.setName(dataTutor.getName());
        response.setLastName(dataTutor.getLastName());
        response.setPhoneNumber(dataTutor.getPhoneNumber());
        response.setEmail(dataTutor.getEmail());
        return response;
    }

    @Override
    public BaseResponse get(Long id) {
        GetDataTutorResponse response = from(id);
        return BaseResponse.builder()
                .data(response)
                .message("DataTutor has been found here")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private GetDataTutorResponse from(Long id){
        return repository.findById(id)
                .map(this::from)
                .orElseThrow(()-> new RuntimeException("DataTutor doesn't exist"));
    }

    @Override
    public BaseResponse create(CreateDataTutorRequest request) {
        DataTutor dataTutor = repository.save(from(request));
        GetDataTutorResponse response = from(dataTutor);
        return BaseResponse
                .builder()
                .data(response)
                .message("DataTutor created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }
    @Autowired
    private IUserService userService;
    private DataTutor from(CreateDataTutorRequest request){
        DataTutor dataTutor = new DataTutor();
        dataTutor.setName(request.getName());
        dataTutor.setLastName(request.getLastName());
        dataTutor.setPhoneNumber(request.getPhoneNumber());
        dataTutor.setEmail(request.getEmail());
        dataTutor.setUser(userService.findUserById(request.getClientId()));
        return dataTutor;
    }
}
