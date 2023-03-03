package com.authentication.authservice.controller;


import com.authentication.authservice.service.AuthService;
import com.myCode.pradnya.server.cult.api.AuthApi;
import com.myCode.pradnya.server.cult.model.AuthSignInBody;
import com.myCode.pradnya.server.cult.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Validated
@CrossOrigin("*")
public class AuthController implements AuthApi {

    @Autowired
    private AuthService authService;

    public AuthController() {
    }

    @Override
    public ResponseEntity<Void> signIn(@Valid AuthSignInBody signInRequest, String xCorrelationID, String xRequestID) {
        String token = authService.signIn(signInRequest.getUserName(),signInRequest.getPassword());
        return new ResponseEntity(token,HttpStatus.OK);
    }


    @SneakyThrows
    @Override
    @PostMapping("/auth/signup")
    public ResponseEntity<Void> signupUser(User user){
       String token = authService.register(user);
        return new ResponseEntity(token, HttpStatus.CREATED);
    }
}
