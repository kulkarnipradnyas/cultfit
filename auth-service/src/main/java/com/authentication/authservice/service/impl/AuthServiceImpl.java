package com.authentication.authservice.service.impl;

import com.authentication.authservice.config.JWTTokenProvider;
import com.authentication.authservice.entity.Role;
import com.authentication.authservice.entity.User;
import com.authentication.authservice.repository.UserRepository;
import com.authentication.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Override
    public String register(@Validated com.myCode.pradnya.server.cult.model.User user) {

        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw  new RuntimeException("User does exist") ;
        }
        User userDb = new User();
        userDb.setUserName(user.getUserName());
        userDb.setEmail(user.getEmail());
        userDb.setPhoneNumber(user.getPhoneNumber());
        userDb.setWorkEmailId(user.getWorkEmailId());
        userDb.setRoles(Set.of((Role) user.getRoles()));
        userDb.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        Set<GrantedAuthority> claims=user.getRoles().stream().map((role)->{
            return new SimpleGrantedAuthority(role);
        }).collect(Collectors.toSet());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getPassword()));


        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
}
