package com.elad.CouponSystemV2Spring.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.repo.CouponsRepository;
import com.elad.CouponSystemV2Spring.service.CompanyServiceImpl;
import com.elad.CouponSystemV2Spring.utills.ArtUtills;
import com.elad.CouponSystemV2Spring.utills.DateUtills;

import lombok.RequiredArgsConstructor;

@Component
@Order(2)
@RequiredArgsConstructor
public class CompanyServiceTesting implements CommandLineRunner{

	public final CompanyServiceImpl companyService;
	public final CouponsRepository couponsRepository;
	@Override
	public void run(String... args) throws Exception {
		ArtUtills.COMPANY_TESTING();
		companyService.setCompanyId(2);
		
			companyService.login("katiacorp@gmail.com", "katiacorp");
			Coupon c1 = Coupon.builder()
					.companyID(companyService.getCompanyDetails().getId())
					.title("bmw")
					.category(Category.CARS)
					.description("bmw")
					.startDate(DateUtills.getDate(29, 1, 2021))
					.endDate(DateUtills.getDate(29, 1, 2022))
					.price(5165)
					.amount(1)
					.image("not availabale")
					.build();
			Coupon c2 = Coupon.builder()
					.companyID(companyService.getCompanyDetails().getId())
					.title("bbb")
					.category(Category.FOOD)
					.description("burger")
					.startDate(DateUtills.getDate(19, 3, 2021))
					.endDate(DateUtills.getDate(19, 6, 2022))
					.price(51.99)
					.amount(9)
					.image("not availabale")
					.build();
			Coupon c3 = Coupon.builder()
					.companyID(companyService.getCompanyDetails().getId())
					.title("grand hotel")
					.category(Category.VACATION)
					.description("2 rooms")
					.startDate(DateUtills.getDate(9, 2, 2021))
					.endDate(DateUtills.getDate(9, 9, 2022))
					.price(150.99)
					.amount(0)
					.image("not availabale").build();
			Coupon c4 = Coupon.builder()
					.companyID(companyService.getCompanyDetails().getId())
					.title("drill")
					.category(Category.ELECTRICITY)
					.description("bosh")
					.startDate(DateUtills.getDate(21, 5, 2021))
					.endDate(DateUtills.getDate(21, 1, 2022))
					.price(25.90)
					.amount(1)
					.image("not availabale")
					.build();
			Coupon c5 = Coupon.builder()
					.companyID(companyService.getCompanyDetails().getId())
					.title("angus")
					.category(Category.FOOD)
					.description("wings")
					.startDate(DateUtills.getDate(26, 2, 2021))
					.endDate(DateUtills.getDate(26, 6, 2022))
					.price(10.99)
					.amount(6)
					.image("not availabale")
					.build();
			Coupon c6 = Coupon.builder()
					.companyID(companyService.getCompanyDetails().getId())
					.title("car battery")
					.category(Category.CARS)
					.description("large")
					.startDate(DateUtills.getDate(25, 8, 2020))
					.endDate(DateUtills.getDate(25, 1, 2022))
					.amount(2)
					.price(22.50)
					.image("not availabale").build();
			couponsRepository.save(c1);
			couponsRepository.save(c2);
			couponsRepository.save(c3);
			couponsRepository.save(c4);
			couponsRepository.save(c5);
			couponsRepository.save(c6);
			companyService.addCoupon(c1);
			companyService.addCoupon(c2);
			System.out.println();
			System.out.println(	companyService.getCompanyDetails());
			System.out.println(companyService.getAllCompanyCoupons());
			companyService.deleteCompanyCoupon(companyService.getOneCompanyCoupon(1));
			Coupon ce3 = companyService.getOneCompanyCoupon(2);
			try {
				ce3.setAmount(15);
				companyService.updateCompanyCoupon(ce3);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			 try {
				 //ce3.setCompanyID(3);
				 ce3.setId(15);
				 companyService.updateCompanyCoupon(ce3);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			 System.out.println(companyService.getOneCompanyCoupon(2));
			 System.out.println(companyService.getAllCoupnsByMaxPrice(200));
			 System.out.println(companyService.getAllCouponsByCategory(Category.CARS));
			 

			
			
	}

}
