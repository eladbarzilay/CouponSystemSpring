package com.elad.CouponSystemV3Spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {
    @NotBlank
    @Size(min = 2, max = 30)
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 30)
    private String password;

}