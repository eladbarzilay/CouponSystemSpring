package com.elad.CouponSystemV2Spring.filter;


import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;

import com.elad.CouponSystemV2Spring.security.ClientType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(3)
//@Component
@RequiredArgsConstructor
public class TokenFilter implements Filter {
    private final com.elad.CouponSystemV2Spring.security.TokenManager tokenManager;
    private final static String COMPANIES = "companies";
    private final static String CUSTOMERS = "customers";
    private final static String ADMIN = "admin";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        System.out.println("url : " + url);

        if (url.endsWith("login") || url.contains("swagger") || url.contains("api-docs")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = (request).getHeader("Authorization");
            System.out.println("token : " + token);
            tokenManager.isExist(token);
            String type = FilterHelper.getType(url);
            System.out.println("type : " + type);

            switch (type) {

                case ADMIN:
                    tokenManager.isControllerAllowed(token, ClientType.ADMINISTRATOR);
                    break;
                case CUSTOMERS:
                    tokenManager.isControllerAllowed(token, ClientType.CUSTOMER);
                    break;
                case COMPANIES:
                    tokenManager.isControllerAllowed(token, ClientType.COMPANY);
                    break;
            }
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
            ((HttpServletResponse) servletResponse).sendError(401, "Bad Request!");
        }
    }
}