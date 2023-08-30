package com.ApiRest.AstroMet.services;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateUserRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.controllers.dtos.responses.GetUserResponse;
import com.ApiRest.AstroMet.entities.User;
import com.ApiRest.AstroMet.entities.projections.UserProjection;
import com.ApiRest.AstroMet.repositories.IUserRepository;
import com.ApiRest.AstroMet.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository repository;
    @Override
    public BaseResponse list() {
        List<GetUserResponse> response = repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("List of User have been obtained correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();

    }

    private GetUserResponse from(User user){
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setAddress(user.getAddress());
        response.setAge(user.getAge());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEducationLevel(user.getEducationLevel());
        response.setRegionOrState(user.getRegionOrState());
        return response;
    }

    @Override
    public BaseResponse get(Long id) {
        GetUserResponse response = from(id);
        return BaseResponse.builder()
                .data(response)
                .message("User has been found here")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User has not been found"));
    }

    private GetUserResponse from(Long id){
        return repository.findById(id)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    @Override
    public BaseResponse getUserByName(String name) {
        List<GetUserResponse> response = from(name);
        return BaseResponse.builder()
                .data(response)
                .message("User has been found by selected name")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private List<GetUserResponse> from (String name){
        return repository.findUserByName(name)
                .stream().map(this::from)
                .collect(Collectors.toList());
    }

    private GetUserResponse from (UserProjection user){
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastName(user.getLastName());
        response.setPassword(user.getPassword());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setAge(user.getAge());
        response.setEmail(user.getEmail());
        response.setEducationLevel(user.getEducationLevel());
        response.setAddress(user.getAddress());
        response.setRegionOrState(user.getRegionOrState());
        return response;
    }

    @Override
    public BaseResponse create(CreateUserRequest request) {
        User user = repository.save(from(request));
        GetUserResponse response = from(user);
        return BaseResponse
                .builder()
                .data(response)
                .message("User created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    private User from (CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAddress(request.getAddress());
        user.setAge(request.getAge());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEducationLevel(request.getEducationLevel());
        user.setRegionOrState(request.getRegionOrState());
        return user;
    }
}
