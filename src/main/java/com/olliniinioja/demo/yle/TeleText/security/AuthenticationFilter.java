package com.olliniinioja.demo.yle.TeleText.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String appId = request.getParameter("app_id");
        String appKey = request.getParameter("app_key");

        if (!("teletext").equals(appId) || !("secret").equals(appKey)) {
            throw new ServletException("Wrong credentials!");
        }

        filterChain.doFilter(request, response);
    }
}