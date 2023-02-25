package com.authentication.authservice.service.impl;

import com.authentication.authservice.config.JWTTokenProvider;
import com.authentication.authservice.entity.Role;
import com.authentication.authservice.entity.User;
import com.authentication.authservice.repository.RoleRepository;
import com.authentication.authservice.repository.UserRepository;
import com.authentication.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import java.util.stream.IntStream;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTTokenProvider jwtTokenProvider;
    @Autowired
    private RoleRepository roleRepository;

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
        List<String> roleStrings = user.getRoles();
        Set<Role> roles = IntStream.range(0, roleStrings.size())
                .mapToObj(i -> new Role((long) i,roleStrings.get(i)))
                .collect(Collectors.toSet());
        userDb.setRoles(roles);
        userDb.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        Set<GrantedAuthority> claims=user.getRoles().stream().map((role)->{
            return new SimpleGrantedAuthority(role);
        }).collect(Collectors.toSet());
        Set<Role> roleDb=user.getRoles().stream().map((r)->{
            return   roleRepository.findByName(r.toString());
        }).collect(Collectors.toSet());

        userRepository.save(userDb);

        String token = jwtTokenProvider.generateToken(user.getUserName());
        return token;
    }
}
