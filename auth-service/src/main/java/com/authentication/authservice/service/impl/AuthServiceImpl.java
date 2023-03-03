package com.authentication.authservice.service.impl;

import com.authentication.authservice.exception.CultServiceException;
import com.authentication.authservice.exception.ErrorCodes;
import com.authentication.authservice.securityConfig.JWTTokenProvider;
import com.authentication.authservice.entity.Role;
import com.authentication.authservice.entity.User;
import com.authentication.authservice.repository.RoleRepository;
import com.authentication.authservice.repository.UserRepository;
import com.authentication.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;


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


        Set<Role> roles = new HashSet<>();
        for (String roleName : user.getRoles()) {
            Role role = roleRepository.findByName(roleName);
            if (role == null) {
                throw new RuntimeException( "Role not found: " + roleName);
            }
            roles.add(role);
        }
        userDb.setRoles(roles);
        userDb.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

//        Set<GrantedAuthority> claims=user.getRoles().stream().map((role)->{
//            return new SimpleGrantedAuthority(role);
//        }).collect(Collectors.toSet());
        Set<Role> roleDb=user.getRoles().stream().map((r)->{
            return   roleRepository.findByName(r.toString());
        }).collect(Collectors.toSet());

        userRepository.save(userDb);

        String token = jwtTokenProvider.generateToken(user.getUserName());
        return token;
    }

    @Override
    public String signIn(String userName, String password) {
       User user= userRepository.findByUserName(userName).orElseThrow(()->{
           throw new CultServiceException(ErrorCodes.E311036,"User does not exist.");
       });
       if(!BCrypt.checkpw(password, user.getPassword())){
           throw new CultServiceException(ErrorCodes.E311036, "Please provide correct password");
       }
        return jwtTokenProvider.generateToken(userName);
    }
}
