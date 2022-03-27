package com.elad.CouponSystemV2Spring1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.elad.CouponSystemV2Spring1.beans.Category;
import com.elad.CouponSystemV2Spring1.beans.Coupon;
import com.elad.CouponSystemV2Spring1.controller.models.LoginDetails;
import com.elad.CouponSystemV2Spring1.controller.models.Response;
import com.elad.CouponSystemV2Spring1.exeptions.LoginException;
import com.elad.CouponSystemV2Spring1.exeptions.NotValidExeption;
import com.elad.CouponSystemV2Spring1.login.ClientType;
import com.elad.CouponSystemV2Spring1.security.TokenManager;
import com.elad.CouponSystemV2Spring1.service.CompanyServiceImpl;
import com.elad.CouponSystemV2Spring1.service.LoginManagerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("companies")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController{

	private CompanyServiceImpl companySeviceImpl;
    private final TokenManager tokenManager;
    private final LoginManagerService loginManagerService;
	
	private int companyID;
	
	
	
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) throws SecurityException, LoginException, NotValidExeption {
        String token = loginManagerService.login(loginDetails.getEmail(), loginDetails.getPassword(), ClientType.COMPANY);
        Response response = new Response();
        response.setClientType(ClientType.COMPANY);
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

	
//    @PostMapping("coupon")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addCompany(@RequestHeader(value = "Authorization") String token, @RequestBody Coupon coupon) throws NotValidExeption {
//    	companySeviceImpl =  (CompanyServiceImpl) tokenManager.getService(token);
//        companySeviceImpl.addCoupon(coupon);
//    }
	
	@PutMapping("coupons")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateCompanyCoupon(@RequestHeader(value = "Authorization") String token, @RequestBody Coupon coupon) throws NotValidExeption {
		companySeviceImpl = (CompanyServiceImpl) tokenManager.getService(token);
		
			companySeviceImpl.updateCompanyCoupon(coupon);

	}


	
	@DeleteMapping("coupons/{couponId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCompanyCoupon(@RequestHeader(value = "Authorization") String token, @PathVariable int couponId) throws NotValidExeption {
		companySeviceImpl.setCompanyId(2);
		companySeviceImpl = (CompanyServiceImpl) tokenManager.getService(token);

		companySeviceImpl.deleteCompanyCouponById(couponId);
	}


	
	@GetMapping("coupon")
	@ResponseStatus(code = HttpStatus.OK)
	public Coupon getOneCompanyCoupon(@RequestParam int couponID) {
		companySeviceImpl.setCompanyId(2);
		return companySeviceImpl.getOneCompanyCoupon(couponID);
	}
	
//	@GetMapping("coupons")
//	@ResponseStatus(code = HttpStatus.OK)
//	public List<Coupon> getAllCompanyCoupons(@RequestHeader(value = "Authorization") String token) {
//		companySeviceImpl.setCompanyId(2);
//		companySeviceImpl = (CompanyServiceImpl) tokenManager.getService(token);
//		return companySeviceImpl.getAllCompanyCoupons();
//	}
	
	@GetMapping("coupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getAllCoupons(@RequestHeader(value = "Authorization") String token) {
		companySeviceImpl =  (CompanyServiceImpl) tokenManager.getService(token);
        return companySeviceImpl.getAllCouponsByCompanyId();
    }

	
	@GetMapping("coupons/Category")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getAllCompanyCouponsByCategorycompany(@RequestHeader(value = "Authorization") String token, @PathVariable Category category) {
		companySeviceImpl.setCompanyId(2);
		companySeviceImpl = (CompanyServiceImpl) tokenManager.getService(token);
		return companySeviceImpl.getAllCouponsByCategory(category);
	}
	
	@GetMapping("coupons/maxPrice")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getAllCompanyCouponsByMaxPrice(@RequestHeader(value = "Authorization") String token, @RequestParam double maxPrice) {
		companySeviceImpl.setCompanyId(2);
		companySeviceImpl = (CompanyServiceImpl) tokenManager.getService(token);
		return companySeviceImpl.getAllCoupnsByMaxPrice(maxPrice);
	}

	@PostMapping("coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestHeader(value = "Authorization") String token, @RequestBody Coupon coupon) throws NotValidExeption {
		companySeviceImpl = (CompanyServiceImpl) tokenManager.getService(token);
        companySeviceImpl.addCoupon(coupon);
    }
    
	@GetMapping("allCoupons")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Coupon> getAllCoupons(){;
		return companySeviceImpl.getAllCoupons();
	}

}
