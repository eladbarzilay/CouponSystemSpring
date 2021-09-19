package com.elad.CouponSystemV2Spring.controller.models;

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
}
