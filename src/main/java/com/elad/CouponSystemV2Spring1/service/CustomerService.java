package com.elad.CouponSystemV2Spring1.service;

import java.util.List;

import com.elad.CouponSystemV2Spring1.beans.Category;
import com.elad.CouponSystemV2Spring1.beans.Coupon;
import com.elad.CouponSystemV2Spring1.beans.Customer;

public interface CustomerService {

//	void purchaseCoupon(Coupon coupon) throws NotValidExeption, ParseException;
	List<Coupon> getAllCustomerCoupons();
	List<Coupon> getCustomerCouponsByCategory(Category category);
	List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice);
	void deleteCustomerCoupon(int id);
	Customer getCustomerDetails();

}
