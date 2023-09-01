package com.olliniinioja.demo.yle.TeleText.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
// FIXME: hacky way to authenticate via URL params on each request - consider using JWT
public class AuthenticationFilter extends OncePerRequestFilter {

    // FIXME: Refactor not to use hard-coded credentials
    private static final String APP_ID = "teletext";
    private static final String APP_KEY = "secret";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String appId = request.getParameter("app_id");
        String appKey = request.getParameter("app_key");

        if (APP_ID.equals(appId) && APP_KEY.equals(appKey)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getServletPath().equals("/")) {
            filterChain.doFilter(request, response);
            return;
        }

        response.sendError(401, "Wrong credentials!");
    }
}