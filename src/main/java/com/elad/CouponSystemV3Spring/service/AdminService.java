package com.elad.CouponSystemV3Spring.service;

import java.util.List;

import com.elad.CouponSystemV3Spring.beans.Company;
import com.elad.CouponSystemV3Spring.beans.Customer;
import com.elad.CouponSystemV3Spring.exeptions.NotValidExeption;

public interface AdminService {

	void addCompany(Company company) throws NotValidExeption;
	void updateCompany(Company company) throws NotValidExeption;
	void deleteCompany(Company company);
	Company getOneCompany(int id);
	List<Company>getAllCompanies();
	void addCustomer(Customer customer) throws NotValidExeption;
	void updateCustomer(Customer customer) throws NotValidExeption;
	void deleteCustomer(Customer customer);
	Customer getOneCustomer(int id);
	List<Customer>getAllCustomers();

	
}
