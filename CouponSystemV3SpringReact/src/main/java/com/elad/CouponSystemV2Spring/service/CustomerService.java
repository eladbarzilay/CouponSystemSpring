package com.elad.CouponSystemV2Spring.service;

import java.text.ParseException;
import java.util.List;

import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.beans.Customer;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;

public interface CustomerService {

	void purchaseCoupon(Coupon coupon) throws NotValidExeption, ParseException;
	List<Coupon> getAllCustomerCoupons();
	List<Coupon> getCustomerCouponsByCategory(Category category);
	List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice);
	void deleteCustomerCoupon(int id);
	Customer getCustomerDetails();

}
