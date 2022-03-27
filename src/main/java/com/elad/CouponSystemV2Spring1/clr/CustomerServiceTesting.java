package com.elad.CouponSystemV2Spring1.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elad.CouponSystemV2Spring1.beans.Category;
import com.elad.CouponSystemV2Spring1.repo.CouponsRepository;
import com.elad.CouponSystemV2Spring1.service.AdminServiceImpl;
import com.elad.CouponSystemV2Spring1.service.CustomerServiceImpl;
import com.elad.CouponSystemV2Spring1.utills.ArtUtills;

import lombok.RequiredArgsConstructor;

@Component
@Order(3)
@RequiredArgsConstructor
public class CustomerServiceTesting implements CommandLineRunner {

	public final CustomerServiceImpl customerService;
	public final CouponsRepository couponsRepository;
	public final AdminServiceImpl adminService;

	@Override
	public void run(String... args) throws Exception {
		ArtUtills.CUSTOMER_TESTING();
//		customerService.setCustomerId(1);
		customerService.login("eladbarzilay@gmail.com", "eladbarzilay");
//		try {
//
//			customerService.purchaseCoupon(couponsRepository.getOne(3));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//
//		customerService.purchaseCoupon(couponsRepository.getOne(5));
//
//		try {
//
//			customerService.purchaseCoupon(couponsRepository.getOne(5));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//
//			customerService.purchaseCoupon(couponsRepository.getOne(6));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		System.out.println(customerService.getAllCustomerCoupons());
		System.out.println(customerService.getCustomerCouponsByCategory(Category.VACATION));
		System.out.println(customerService.getCustomerCouponsByMaxPrice(11));
		
	}

	
}
