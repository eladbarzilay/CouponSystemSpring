package com.elad.CouponSystemV2Spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.elad.CouponSystemV2Spring.exeptions.LoginException;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;
import com.elad.CouponSystemV2Spring.login.ClientType;
import com.elad.CouponSystemV2Spring.security.TokenManager;


@Service
@RequiredArgsConstructor
public class LoginManagerService {
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;
    private final TokenManager tokenManager;

    public String login(String email, String password, ClientType clientType) throws LoginException, NotValidExeption {
        switch (clientType) {
            case ADMINISTRATOR:
                return loginFactory(adminService,email,password,clientType, adminService.getAdminId());
            case COMPANY:
                return loginFactory(companyService,email,password,clientType,companyService.getCompanyID());
            case CUSTOMER:
                return loginFactory(customerService,email,password,clientType, customerService.getCustomerID());
        }
        throw new LoginException("Incorrect client type");
    }

    private String loginFactory(ClientService cs,String email,String pass, ClientType clientType,int clientId) throws LoginException, NotValidExeption {
        if (cs.login(email, pass)) {
            return tokenManager.addToken(cs, clientType,clientId);
        }
        throw new LoginException("Email or Password are incorrect");
    }
}