package com.elad.CouponSystemV3Spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elad.CouponSystemV3Spring.controller.models.LoginDetails;
import com.elad.CouponSystemV3Spring.controller.models.LogoutDetails;
import com.elad.CouponSystemV3Spring.controller.models.Response;
import com.elad.CouponSystemV3Spring.exeptions.CouponSystemException;
import com.elad.CouponSystemV3Spring.exeptions.LoginException;
import com.elad.CouponSystemV3Spring.exeptions.NotValidExeption;
import com.elad.CouponSystemV3Spring.login.ClientType;
import com.elad.CouponSystemV3Spring.security.TokenManager;
import com.elad.CouponSystemV3Spring.service.LoginManagerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@RequestMapping("client")
@CrossOrigin(origins = "http://localhost:3000")
public abstract class ClientController {

    private final TokenManager tokenManager;
    private final LoginManagerService loginManagerService;
    private String token;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) throws SecurityException, LoginException, NotValidExeption {
        token = loginManagerService.login(loginDetails.getEmail(), loginDetails.getPassword(), ClientType.ADMINISTRATOR);
        Response response = new Response();
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("logout")
    public ResponseEntity<?> logout(LogoutDetails logoutDetails) throws CouponSystemException {
        String logoutToken = logoutDetails.getToken();
        if (!token.equals(logoutToken)) {
            throw new CouponSystemException("Wrong token please try again");
        }
        tokenManager.removeToken(logoutToken);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
