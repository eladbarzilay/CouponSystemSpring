package com.elad.CouponSystemV2Spring.controller.models;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.elad.CouponSystemV2Spring.login.ClientType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
	   private String firstName;
	    private String lastName;
	    private String token;
	    @Enumerated(EnumType.STRING)
	    private ClientType clientType;
}
