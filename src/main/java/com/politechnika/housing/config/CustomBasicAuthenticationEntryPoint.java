package com.politechnika.housing.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "Basic realm=" + getRealmName());

        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 :" + authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("test_realms");
        super.afterPropertiesSet();
    }
}
