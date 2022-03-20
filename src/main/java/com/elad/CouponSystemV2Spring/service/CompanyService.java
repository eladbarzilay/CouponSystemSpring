package com.elad.CouponSystemV2Spring.service;

import java.util.List;

import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.beans.Company;
import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;

public interface CompanyService {

//	void addCompanyCoupon(Coupon coupon);
	Coupon updateCompanyCoupon(Coupon coupon) throws NotValidExeption;
	void deleteCompanyCoupon(Coupon coupon);
	Coupon getOneCompanyCoupon(int id);
	List<Coupon>getAllCompanyCoupons();
	List<Coupon>getAllCouponsByCategory(Category category);
	List<Coupon>getAllCoupnsByMaxPrice(double maxPrice);
	Company getCompanyDetails(); 
	
}
