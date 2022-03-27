package com.elad.CouponSystemV2Spring1.login;

import org.springframework.stereotype.Service;

import com.elad.CouponSystemV2Spring1.service.AdminServiceImpl;
import com.elad.CouponSystemV2Spring1.service.CompanyServiceImpl;
import com.elad.CouponSystemV2Spring1.service.CustomerServiceImpl;

@Service
public class LoginManager {

	public Object ClientService(String email, String password, ClientType clientType) {
		switch (clientType) {
		case ADMINISTRATOR:
			System.out.println("admin login testing");
			if (email.equals("admin@admin.com") && password.equals("admin")) {
				System.out.println("hello admin");
				return new AdminServiceImpl();
			}
			System.out.println("try again");
			return null;
		case COMPANY:
			System.out.println("company login testing");
			if (email.equals("aa") && password.equals("aa")) {
				System.out.println("hello company");
				return new CompanyServiceImpl();
			}

			System.out.println("try again");
			return null;
		case CUSTOMER:
			System.out.println("customer login testing");
			if (email.equals("bb") && password.equals("bb")) {
				System.out.println("hello customer");
				return new CustomerServiceImpl();
			}

			System.out.println("try again");
			return null;
		default:
			System.out.println("undefined");
			break;
		}
		return null;
	}
}
