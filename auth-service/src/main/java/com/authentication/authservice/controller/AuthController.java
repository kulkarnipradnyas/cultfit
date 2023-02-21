package com.authentication.authservice.controller;


import com.authentication.authservice.service.AuthService;
import com.myCode.pradnya.server.cult.api.AuthApi;
import com.myCode.pradnya.server.cult.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@Validated
@CrossOrigin("*")
public class AuthController implements AuthApi {

    private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public AuthController() {
    }

    @Override
    @PostMapping("/auth/signIn")
     public   ResponseEntity<Void> signIn(String xCorrelationID,String xRequestID){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
    @PostMapping(value = {"/auth/signup"})
    private String signup(@RequestHeader("xCorrelationID") String xCorrelationID,
                          @RequestHeader("xRequestID") String xRequestID,
                          @RequestBody User user){
           String token = authService.register(user);
            return token;
    }
}
