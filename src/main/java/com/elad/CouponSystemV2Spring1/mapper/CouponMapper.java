package com.elad.CouponSystemV2Spring1.mapper;

import org.springframework.stereotype.Component;

import com.elad.CouponSystemV2Spring1.beans.Coupon;
import com.elad.CouponSystemV2Spring1.dto.entities.CouponDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CouponMapper implements Mapper<Coupon, CouponDto> {

    @Override
    public Coupon toDao(CouponDto couponDto) {
        return Coupon.builder().
        		
                companyID(couponDto.getCompanyId()).
                category(couponDto.getCategory()).
                title(couponDto.getTitle()).
                description(couponDto.getDescription()).
                startDate(couponDto.getStartDate()).
                endDate(couponDto.getEndDate()).
                amount(couponDto.getAmount()).
                price(couponDto.getPrice()).
                image(couponDto.getImage()).
                build();
    }

    @Override
    public CouponDto toDto(Coupon coupon) {
        return CouponDto.builder().
                companyId(coupon.getCompanyID()).
                category(coupon.getCategory()).
                title(coupon.getTitle()).
                description(coupon.getDescription()).
                startDate(coupon.getStartDate()).
                endDate(coupon.getEndDate()).
                amount(coupon.getAmount()).
                price(coupon.getPrice()).
                image(coupon.getImage()).
                build();
    }

    @Override
    public List<Coupon> toDaoList(List<CouponDto> couponDtos) {
        return couponDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<CouponDto> toDtoList(List<Coupon> coupons) {
        return coupons.stream().map(this::toDto).collect(Collectors.toList());
    }
}