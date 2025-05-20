package com.cob.product.filter;

import com.lib.token.cob.model.TokenDetails;
import com.lib.token.cob.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            boolean isValid = jwtUtil.validateToken(token);
            if (isValid) {
                TokenDetails tokenDetails = jwtUtil.getTokenDetails(token);
                httpRequest.setAttribute("role", tokenDetails.getRole());
                chain.doFilter(request, response);
            } else {
                sendErrorResponse((HttpServletResponse) response, "Invalid JWT Token:" );
            }
        }else {
            sendErrorResponse((HttpServletResponse) response, "Missing Authorization Header");
        }
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"Unauthorized\", \"message\": \"" + message + "\"}");
        response.getWriter().flush();
    }
}
