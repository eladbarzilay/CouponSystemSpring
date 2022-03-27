package com.elad.CouponSystemV3Spring.clr;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elad.CouponSystemV3Spring.beans.Company;
import com.elad.CouponSystemV3Spring.beans.Customer;
import com.elad.CouponSystemV3Spring.service.AdminServiceImpl;
import com.elad.CouponSystemV3Spring.utills.ArtUtills;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;

//@Component
@Order(1)
@RequiredArgsConstructor
public class AdminServiceTesting implements CommandLineRunner{

	public final AdminServiceImpl adminService;

	@Override
	public void run(String... args) throws Exception {
		ArtUtills.ADMIN_TESTING();
		try {			
			adminService.login("Admin", "admi");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {			
			adminService.login("Admin@admin.com", "admin");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Company c1 = Company.builder().name("eladcorp").email("eladcorp@gmail.com").password("eladcorp").build();
		Company c2 = Company.builder().name("katiacorp").email("katiacorp@gmail.com").password("katiacorp").build();
		Company c3 = Company.builder().name("taliacorp").email("taliacorp@gmail.com").password("taliacorp").build();
		Company c4 = Company.builder().name("seancorp").email("seancorp@gmail.com").password("seancorp").build();
		Customer cus1 = Customer.builder().firstName("elad").lastName("barzilay").email("eladbarzilay@gmail.com").password("eladbarzilay").coupons(Arrays.asList()).build();
		Customer cus2 = Customer.builder().firstName("katia").lastName("barzilay").email("katiabarzilay@gmail.com").password("katiabarzilay").coupons(Arrays.asList()).build();
		Customer cus3 = Customer.builder().firstName("talia").lastName("barzilay").email("taliabarzilay@gmail.com").password("taliabarzilay").coupons(Arrays.asList()).build();
		Customer cus4 = Customer.builder().firstName("sean").lastName("barzilay").email("seanbarzilay@gmail.com").password("seanbarzilay").coupons(Arrays.asList()).build();

		System.out.println("_____ add company works _______");
		adminService.addCompany(c1);
		adminService.addCompany(c2);
		adminService.addCompany(c3);
		adminService.addCompany(c4);
		System.out.println("_____ add company dont work _______");
		try {
			adminService.addCompany(c1);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("_____ get all companies _______");
		System.out.println(adminService.getAllCompanies());
		Company c5 = adminService.getOneCompany(1);
		System.out.println("_____ update company works _______");
		System.out.println("befor update");
		System.out.println(adminService.getOneCompany(1));
		c5.setEmail("elel@gmail.com");
		adminService.updateCompany(c5);
		System.out.println("after update");
		System.out.println(adminService.getOneCompany(1));
		System.out.println("_____ update company dont work_______");
		c5.setId(15);
		c5.setName("elel");
		try {
			adminService.updateCompany(c5);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("____ get one company ______");
		System.out.println(adminService.getOneCompany(2));
		System.out.println("____ delete company ______");
		adminService.deleteCompany(c4);
		System.out.println("_______ get all companies after delete __________");
		System.out.println(adminService.getAllCompanies());
		System.out.println("_______________________________");
		
		adminService.addCustomer(cus1);
		adminService.addCustomer(cus2);
		adminService.addCustomer(cus3);
		adminService.addCustomer(cus4);
		

	}
	
		
	
	
	
}
