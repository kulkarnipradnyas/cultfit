package com.authentication.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig  {

    private JWTAuthorizationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig() {
        // default constructor
    }

    public SecurityConfig(JWTAuthorizationEntryPoint authenticationEntryPoint, JwtAuthenticationFilter authenticationFilter) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    public SecurityConfig(JWTAuthorizationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests((authorize) -> authorize.anyRequest().authenticated()) // All requests require authentication
////                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .cors(Customizer.withDefaults())// validates access tokens as JWTs
//                .build();
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        //authorize.anyRequest().authenticated()
                        authorize
                                .antMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                                .antMatchers(HttpMethod.POST, "/auth/signIn").permitAll()
                                .anyRequest().authenticated()

                )
                //.addFilterBefore(new PermitAllFilter("/auth/signup"), UsernamePasswordAuthenticationFilter.class)
              //  .addFilterBefore(authenticationFilter, PermitAllFilter.class)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//                .exceptionHandling( exception -> exception
//                        .authenticationEntryPoint(authenticationEntryPoint)
//                ).sessionManagement( session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                );

//        http.addFilterAfter(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}