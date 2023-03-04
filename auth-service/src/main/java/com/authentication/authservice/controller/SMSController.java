package com.authentication.authservice.controller;


import com.myCode.pradnya.server.cult.api.AuthApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@CrossOrigin("*")
public class SMSController  {
//    private final SMSService smsService;
//
//    @Autowired
//    public SMSController(SMSService smsService) {
//        this.smsService = smsService;
//    }

//    @Override
//    public ResponseEntity<Void> authExampleGet(HttpSession session) {
//        return AuthApi.super.authExampleGet();
//    }

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