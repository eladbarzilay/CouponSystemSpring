package com.elad.CouponSystemV2Spring.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    @NotBlank
    @JsonProperty(value = "token")
    private UUID uuid;
}