package com.elad.CouponSystemV3Spring.login;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import lombok.RequiredArgsConstructor;
//@Component
@RequiredArgsConstructor
@Order(4)
public class loginTesting implements CommandLineRunner {

	private final  LoginManager LoginManager;
	@Override
	public void run(String... args) throws Exception {
		LoginManager.ClientService("admin@dmin.com", "admin", ClientType.ADMINISTRATOR);
		LoginManager.ClientService("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
		LoginManager.ClientService("aa", "aa", ClientType.COMPANY);
		LoginManager.ClientService("bb", "bb", ClientType.CUSTOMER);
		LoginManager.ClientService("aa", "aa", ClientType.CUSTOMER);
		LoginManager.ClientService("b", "bb", ClientType.CUSTOMER);
		LoginManager.ClientService("bb", "b", ClientType.CUSTOMER);
		LoginManager.ClientService("bb", "bb", ClientType.COMPANY);
		
		
	}

}
