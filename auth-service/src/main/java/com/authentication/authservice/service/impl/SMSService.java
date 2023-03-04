package com.authentication.authservice.service.impl;



import com.myCode.pradnya.server.cult.model.SMS;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.Random;

//@Service
public class SMSService {
//    private static final String SESSION_OTP = "SESSION_OTP";
//    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//    private static final int OTP_LENGTH = 6;
//    @Value("${twilio.twilio_account_sid}")
//    private String ACCOUNT_SID;
//
//    @Value("${twilio.twilio_auth_token}")
//    private String AUTH_TOKEN;
//
//    @Value("${twilio.twilioPhoneNumber}")
//    private String FROM_NUMBER;
//
//    private final SimpMessagingTemplate simpMessagingTemplate;
//    public SMSService(SimpMessagingTemplate simpMessagingTemplate) {
//        this.simpMessagingTemplate = simpMessagingTemplate;
//    }
//    @PostConstruct
//    public void init() {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//    }
//    public void sendOtp(String toPhoneNumber, HttpSession session) {
//        String otp = generateOtp();
//        session.setAttribute(SESSION_OTP, otp);
//        String message = "Your OTP is " + otp;
//        Message.creator(
//                new PhoneNumber(toPhoneNumber),
//                new PhoneNumber(FROM_NUMBER),
//                message
//        ).create();
//    }
//
//    public boolean verifyOtp(String enteredOtp, HttpSession session) {
//        String otp = (String) session.getAttribute(SESSION_OTP);
//        return enteredOtp.equals(otp);
//    }
//
//    private String generateOtp() {
//        StringBuilder sb = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < OTP_LENGTH; i++) {
//            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
//            sb.append(ALPHA_NUMERIC_STRING.charAt(index));
//        }
//        return sb.toString();
//    }
}
