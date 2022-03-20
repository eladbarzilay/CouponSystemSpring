package com.elad.CouponSystemV2Spring.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.elad.CouponSystemV2Spring.beans.Company;
import com.elad.CouponSystemV2Spring.beans.Customer;
import com.elad.CouponSystemV2Spring.controller.models.LoginDetails;
import com.elad.CouponSystemV2Spring.controller.models.Response;
import com.elad.CouponSystemV2Spring.exeptions.LoginException;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;
import com.elad.CouponSystemV2Spring.login.ClientType;
import com.elad.CouponSystemV2Spring.security.TokenManager;
import com.elad.CouponSystemV2Spring.service.AdminServiceImpl;
import com.elad.CouponSystemV2Spring.service.LoginManagerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController{

	private AdminServiceImpl adminService;
    private final TokenManager tokenManager;
    private final LoginManagerService loginManagerService;
	

	
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDetails loginDetails) throws SecurityException, LoginException, NotValidExeption {
        String token = loginManagerService.login(loginDetails.getEmail(), loginDetails.getPassword(), ClientType.ADMINISTRATOR);
        Response response = new Response();
        response.setClientType(ClientType.ADMINISTRATOR);
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
	@PutMapping("customer")
	@ResponseStatus(code = HttpStatus.CREATED)
    public void addCustomer(@RequestHeader(value = "Authorization") String token, @RequestBody Customer customer) throws NotValidExeption {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        adminService.addCustomer(customer);
    }
	
	@PostMapping("customer")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestHeader(value = "Authorization") String token, @RequestBody Customer customer) throws NotValidExeption  {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        adminService.updateCustomer(customer);
    }
	
	@DeleteMapping("customer/{customerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@RequestHeader(value = "Authorization") String token, @PathVariable int customerId)  {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        adminService.deleteCustomerById(customerId);
    }
	
	@GetMapping("customer")
	@ResponseStatus(code = HttpStatus.OK)
    public Customer getOneCustomer(@RequestHeader(value = "Authorization") String token, @PathVariable int customerId) {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        return adminService.getOneCustomer(customerId);
    }
	
	@GetMapping("customers")
	@ResponseStatus(code = HttpStatus.OK)
	   public List<Customer> getAllCustomers(@RequestHeader(value = "Authorization") String token) {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        return adminService.getAllCustomers();
    }
	
	@PutMapping("company")
	@ResponseStatus(code = HttpStatus.CREATED)
    public void addCompany(@RequestHeader(value = "Authorization") String token, @RequestBody Company company) throws NotValidExeption  {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        adminService.addCompany(company);
    }
	
	@PostMapping("company")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestHeader(value = "Authorization") String token, @RequestBody Company company) throws NotValidExeption  {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        adminService.updateCompany(company);
    }
	
	@DeleteMapping("company/{companyId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestHeader(value = "Authorization") String token, @PathVariable int companyId) throws NotValidExeption  {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        adminService.deleteCompanyById(companyId);
    }
	
	@GetMapping("company")
	@ResponseStatus(code = HttpStatus.OK)
    public Company getOneCompany(@RequestHeader(value = "Authorization") String token, @PathVariable int companyId) {
        adminService = (AdminServiceImpl) tokenManager.getService(token);
        return adminService.getOneCompany(companyId);
	}
	
	@GetMapping("companies")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Company>getAllCompanies(@RequestHeader(value = "Authorization") String token){
		adminService = (AdminServiceImpl) tokenManager.getService(token);
		return adminService.getAllCompanies();
	}

}
