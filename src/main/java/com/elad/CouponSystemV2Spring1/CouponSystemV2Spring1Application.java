
package com.elad.CouponSystemV2Spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CouponSystemV2Spring1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CouponSystemV2Spring1Application.class, args);
		System.out.println("IoC Was Loaded");
		

	}

}
