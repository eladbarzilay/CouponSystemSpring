package com.elad.CouponSystemV2Spring.tasks;

import java.text.ParseException;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;

import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.repo.CouponsRepository;
import com.elad.CouponSystemV2Spring.utills.DateUtills;

import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class DailyJob {

	public final CouponsRepository couponsRepository;

	@Scheduled(fixedRate = 1000 * 15)
	public void deleteExpiredCoupons() throws ParseException {
		List<Coupon> getAllCoupons = couponsRepository.findAll();
		for (Coupon coupon : getAllCoupons) {
			if (coupon.getEndDate().before(DateUtills.getDate(25, 11, 2021))) {
				couponsRepository.delete(coupon);
				System.out.println("coupon id " + coupon.getId() + " deleted");
			}
		}
	}
}
