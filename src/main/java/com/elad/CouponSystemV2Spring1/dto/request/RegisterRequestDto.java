package com.elad.CouponSystemV2Spring1.dto.request;


import com.elad.CouponSystemV2Spring1.login.ClientType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {
    @NotBlank
    @Size(min = 2, max = 30)
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 30)
    private String password;

    @JsonProperty(value = "type")
    @Enumerated(EnumType.STRING)
    private ClientType clientType;
}