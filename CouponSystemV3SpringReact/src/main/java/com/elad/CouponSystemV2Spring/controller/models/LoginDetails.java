package com.elad.CouponSystemV2Spring.controller.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.elad.CouponSystemV2Spring.security.ClientType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDetails {



	    private String email;
	    private String password;
	    @Enumerated(EnumType.STRING)
	    private ClientType clientType;
	}

