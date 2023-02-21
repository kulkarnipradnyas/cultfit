package com.authentication.authservice.controller;


import com.authentication.authservice.service.AuthService;
import com.myCode.pradnya.server.cult.api.AuthApi;
import com.myCode.pradnya.server.cult.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin("*")
public class AuthController implements AuthApi {

    @Autowired
    private AuthService authService;

    public AuthController() {
    }

    @Override
    @PostMapping("/auth/signIn")
     public   ResponseEntity<Void> signIn(String xCorrelationID,String xRequestID){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
    @Override
    @PostMapping("/auth/signup")
    public ResponseEntity<Void> signupUser(@RequestBody User user){
           String token = authService.register(user);
            return new ResponseEntity(token,HttpStatus.OK);
    }
}
