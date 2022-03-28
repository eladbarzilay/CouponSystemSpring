package com.elad.CouponSystemV2Spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.beans.Customer;
import com.elad.CouponSystemV2Spring.controller.models.LoginDetails;
import com.elad.CouponSystemV2Spring.controller.models.Response;
import com.elad.CouponSystemV2Spring.exeptions.LoginException;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;
import com.elad.CouponSystemV2Spring.login.ClientType;
import com.elad.CouponSystemV2Spring.security.TokenManager;
import com.elad.CouponSystemV2Spring.service.CustomerServiceImpl;
import com.elad.CouponSystemV2Spring.service.LoginManagerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	 private  CustomerServiceImpl customerServiceImpl;
	    private final TokenManager tokenManager;
	    private final LoginManagerService loginManagerService;
	
	 private int customerID;
	 
	    @PostMapping("login")
	    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) throws SecurityException, LoginException, NotValidExeption {
	    	String token = loginManagerService.login(loginDetails.getEmail(), loginDetails.getPassword(), ClientType.CUSTOMER);
	        Response response = new Response();
	        response.setClientType(ClientType.CUSTOMER);
	        response.setToken(token);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }

	    @PostMapping("coupons/{couponId}")
	    @ResponseStatus(HttpStatus.OK)
	    public void purchaseCoupon(
	            @RequestHeader(value = "Authorization") String token,
	            @PathVariable int couponId) throws NotValidExeption  {
	        customerServiceImpl = (CustomerServiceImpl) tokenManager.getService(token);
	        customerServiceImpl.purchaseCoupon(couponId);
	    }
	
	@GetMapping("coupons")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getAllCustomerCoupons(@RequestHeader(value = "Authorization") String token) {
        System.out.println("I got a " + token);
        customerServiceImpl = (CustomerServiceImpl) tokenManager.getService(token);
		return customerServiceImpl.getAllCustomerCoupons();
	}

	@GetMapping("coupons/category")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getCustomerCouponsByCategory(@RequestHeader(value = "Authorization") String token, @PathVariable Category category) {
		
		customerServiceImpl = (CustomerServiceImpl) tokenManager.getService(token);
		return customerServiceImpl.getCustomerCouponsByCategory(category);
	}

	@GetMapping("coupons/maxPrice")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getCustomerCouponsByMaxPrice(@RequestHeader(value = "Authorization") String token, @PathVariable double maxPrice) {
		
		customerServiceImpl = (CustomerServiceImpl) tokenManager.getService(token);
		return customerServiceImpl.getCustomerCouponsByMaxPrice(maxPrice);
	}



	@GetMapping("details")
	public Customer getCustomerDetails(@RequestHeader(value = "Authorization") String token) {
		
		customerServiceImpl = (CustomerServiceImpl) tokenManager.getService(token);
		return customerServiceImpl.getCustomerDetails();
	}


	@GetMapping("allCoupons")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getAllCoupons(){;
		return customerServiceImpl.getAllCoupons();
	}


}
