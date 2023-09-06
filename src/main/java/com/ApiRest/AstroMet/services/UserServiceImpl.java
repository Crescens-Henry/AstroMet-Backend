package com.ApiRest.AstroMet.services;

import com.ApiRest.AstroMet.controllers.dtos.requests.CreateUserRequest;
import com.ApiRest.AstroMet.controllers.dtos.responses.BaseResponse;
import com.ApiRest.AstroMet.controllers.dtos.responses.GetUserResponse;
import com.ApiRest.AstroMet.controllers.exceptions.NotFoundException;
import com.ApiRest.AstroMet.entities.User;
import com.ApiRest.AstroMet.repositories.IUserRepository;
import com.ApiRest.AstroMet.security.UserDetailsImpl;
import com.ApiRest.AstroMet.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public BaseResponse get(String email) {
        User user = repository.findOneByName(email)
                .orElseThrow(NotFoundException::new);

        GetUserResponse response=toGetUserResponse(user);
        return BaseResponse.builder()
                .data(response)
                .message("The user has been found with the email:" + response.getEmail())
                .success(true)
                .httpStatus(HttpStatus.FOUND).build();
    }

    @Override
    public BaseResponse create(CreateUserRequest request) {
        Optional<User> possibleCopy = repository.findOneByName(request.getName());

        if(possibleCopy.isPresent()){
            throw new RuntimeException("the user exist"); // (RegisterException)
        }
        User user = repository.save(toUser(request));
        GetUserResponse response=toGetUserResponse(user);
        return BaseResponse.builder()
                .data(response)
                .message("The user has been created with id: "+ response.getId())
                .success(true)
                .httpStatus(HttpStatus.CREATED).build();
    }


    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public User getUserByName(String email) {
        return repository.findOneByName(email)
                .orElseThrow(NotFoundException::new);
    }

    private GetUserResponse toGetUserResponse(User user){

        GetUserResponse response= new GetUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());

        return response;
    }


    private User toUser(CreateUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;
    }
}

