package com.elad.CouponSystemV3Spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elad.CouponSystemV3Spring.beans.Coupon;

public interface CouponsRepository extends JpaRepository<Coupon, Integer>{

	List<Coupon> findCouponsByCompanyID(int id);

}
