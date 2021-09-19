package com.elad.CouponSystemV2Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;
import com.elad.CouponSystemV2Spring.repo.CompaniesRepository;
import com.elad.CouponSystemV2Spring.repo.CouponsRepository;
import com.elad.CouponSystemV2Spring.repo.CustomerRepository;

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
