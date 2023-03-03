package com.authentication.authservice.controller;


import com.authentication.authservice.service.impl.SMSService;
import com.myCode.pradnya.server.cult.api.AuthApi;
import com.myCode.pradnya.server.cult.model.AuthSendOtpBody;
import com.myCode.pradnya.server.cult.model.AuthVerifyOtpBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@Validated
@CrossOrigin("*")
public class SMSController implements AuthApi {
    private final SMSService smsService;

    @Autowired
    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @Override
    public ResponseEntity<Void> authExampleGet(HttpSession session) {
        return AuthApi.super.authExampleGet();
    }

    //    @PostMapping("/auth/sendOtp")
//    @Override
//    public ResponseEntity<Map<String, String>> sendOtp(Map<String, String> requestMap,String xCorrelationID, String xRequestID, HttpSession session) {
//        String phoneNumber = requestMap.get("phoneNumber");
//        smsService.sendOtp(phoneNumber, session);
//        Map<String, String> responseMap = new HashMap<>();
//        responseMap.put("message", "OTP sent successfully");
//        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
//
//    }
//
//    @PostMapping("/auth/verifyOtp")
//    @Override
//    public ResponseEntity<Void> verifyOtp(Map<String, String> requestMap,String xCorrelationID, String xRequestID ,HttpSession session) {
//        String enteredOtp = requestMap.get("otp");
//        boolean isOtpValid = smsService.verifyOtp(enteredOtp, session);
//        String msg= "message: OTP verification failed";
//        if (isOtpValid) {
//            msg= "message: OTP verified successfully";
//            return new ResponseEntity( msg,HttpStatus.OK);
//        }
//
//        return new ResponseEntity( msg,HttpStatus.BAD_REQUEST);
//
//    }

}