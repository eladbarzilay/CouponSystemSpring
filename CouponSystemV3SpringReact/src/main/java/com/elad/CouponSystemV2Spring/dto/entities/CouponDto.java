package com.elad.CouponSystemV2Spring.dto.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.utills.DateUtills;

import java.util.Date;

@Data
@Builder
public class CouponDto {
    private int id;
    private int companyId;

    @NotBlank
    @Size(min = 2, max = 30)
    private String title;

    @NotBlank
    @Size(min = 2, max = 30)
    private String description;

    @NotBlank
    @Size(min = 2, max = 30)
    private String image;

    private Date startDate;
    private Date endDate;

    @Positive
    private int amount;

    @Positive
    private double price;

    @Enumerated(EnumType.ORDINAL)
    private Category category;


    
}



