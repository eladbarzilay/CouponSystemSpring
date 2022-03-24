package com.elad.CouponSystemV3Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elad.CouponSystemV3Spring.exeptions.NotValidExeption;
import com.elad.CouponSystemV3Spring.repo.CompaniesRepository;
import com.elad.CouponSystemV3Spring.repo.CouponsRepository;
import com.elad.CouponSystemV3Spring.repo.CustomerRepository;

@Component
public abstract class ClientService {
	@Autowired
	protected CompaniesRepository companiesRepository;
	@Autowired
	protected  CustomerRepository customerRepository;
	@Autowired
	protected CouponsRepository couponsRepository;
	
	
	public abstract boolean login(String email,String password) throws NotValidExeption;
}
