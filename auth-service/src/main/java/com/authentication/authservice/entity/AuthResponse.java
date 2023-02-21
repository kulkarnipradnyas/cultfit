package com.authentication.authservice.entity;

import lombok.*;

import java.util.Collection;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class AuthResponse {
    private String userId;

    private String refreshToken;

    private long expireAt;

    private String accessToken;

    private Collection<String> authorities;
}
