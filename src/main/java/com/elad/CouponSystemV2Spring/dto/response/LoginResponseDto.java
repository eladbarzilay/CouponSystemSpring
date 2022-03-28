package com.elad.CouponSystemV2Spring.dto.response;

import com.elad.CouponSystemV2Spring.login.ClientType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    @NotBlank
    @JsonProperty(value = "token")
    private UUID uuid;
}