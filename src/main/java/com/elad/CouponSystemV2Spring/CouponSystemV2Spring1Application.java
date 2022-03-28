
package com.elad.CouponSystemV2Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableJpaRepositories("com.elad.CouponSystemV2Spring") // Add this
//@EntityScan("com.elad.CouponSystemV2Spring") // Add this 
public class CouponSystemV2Spring1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CouponSystemV2Spring1Application.class, args);
		System.out.println("IoC Was Loaded");
		

	}

}
