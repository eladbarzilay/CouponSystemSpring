package com.elad.CouponSystemV2Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elad.CouponSystemV2Spring.beans.Coupon;

public interface CouponsRepository extends JpaRepository<Coupon, Integer>{

}
