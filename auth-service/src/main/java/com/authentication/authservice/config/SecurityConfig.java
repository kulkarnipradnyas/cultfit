package com.authentication.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private JWTAuthorizationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;


    public SecurityConfig() {
        // default constructor
    }

    public SecurityConfig(JWTAuthorizationEntryPoint authenticationEntryPoint,JwtAuthenticationFilter authenticationFilter ) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFilter=authenticationFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
//    @Bean
//    public JwtAuthenticationFilter authenticationFilter() {
//        return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
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
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterAfter(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

//        http.addFilterAfter(authenticationFilter, UsernamePasswordAuthenticationFilter.class);


    }

}