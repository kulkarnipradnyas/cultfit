package com.authentication.authservice.config;

import com.authentication.authservice.entity.User;
import com.authentication.authservice.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user= userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("No user found"));
            Set<GrantedAuthority> claims = user.getRoles().stream().map((role) -> {
                return new SimpleGrantedAuthority(role.getName());
            }).collect(Collectors.toSet());
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), claims);

    }
}
