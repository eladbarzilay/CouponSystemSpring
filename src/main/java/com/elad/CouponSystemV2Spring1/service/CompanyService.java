package com.elad.CouponSystemV2Spring1.service;

import java.util.List;

import com.elad.CouponSystemV2Spring1.beans.Category;
import com.elad.CouponSystemV2Spring1.beans.Company;
import com.elad.CouponSystemV2Spring1.beans.Coupon;
import com.elad.CouponSystemV2Spring1.exeptions.NotValidExeption;

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
