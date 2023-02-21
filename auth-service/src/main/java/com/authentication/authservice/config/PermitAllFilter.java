package com.authentication.authservice.config;

import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PermitAllFilter extends OncePerRequestFilter {

    private final String path;

    public PermitAllFilter(String path) {
        this.path = path;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (path.equals(request.getServletPath()) && HttpMethod.POST.matches(request.getMethod())) {
            filterChain.doFilter(request, response);
        } else {
            super.doFilter(request, response, filterChain);
        }
    }
}