package com.elad.CouponSystemV2Spring1.dto.entities;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class CompanyDto {
    private int id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank
    @Size(min = 2, max = 30)
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 30)
    private String password;

}