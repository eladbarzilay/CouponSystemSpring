package com.elad.CouponSystemV3Spring.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.elad.CouponSystemV3Spring.beans.Company;
import com.elad.CouponSystemV3Spring.beans.Customer;
import com.elad.CouponSystemV3Spring.exeptions.NotValidExeption;

import lombok.Getter;


@Service
@Scope("prototype")
@Getter
public class AdminServiceImpl extends ClientService implements AdminService {
	
	private int adminId;
	
    public AdminServiceImpl() {
        super();
    }

	@Override
	public boolean login(String email, String password) throws NotValidExeption {
		if (email.equalsIgnoreCase("admin@admin.com")&&password.equalsIgnoreCase("admin")) {
			System.out.println("welcome admin");
			return true;
		}		
		throw new NotValidExeption("not admin");
		
		
	}

	@Override
	public void addCompany(Company company) throws NotValidExeption {
		List<Company> companies = companiesRepository.findAll();
		for (Company comp : companies) {
			if (comp.getName().equals(company.getName()) || comp.getEmail().equals(company.getEmail())) {
				throw new NotValidExeption("****company already exist****");
			}
		}
		companiesRepository.save(company);
		System.out.println("company added !");
	}

//	@Override
//	public void updateCompany(Company company) throws NotValidExeption {
//		List<Company> companies = companiesRepository.findAll();
//		for (Company comp : companies) {
//			if (comp.getId() == company.getId() && comp.getName().equals(company.getName())) {
//				companiesRepository.saveAndFlush(company);
//				System.out.println("company updated !");
//				break;
//			}
//			throw new NotValidExeption("****id or company name cant be changed****");
//
//		}
//		
//	}
    public void updateCompany(Company company) throws NotValidExeption {
        Company toCompare = companiesRepository.findByName(company.getName());
        if (toCompare == null) {
            throw new NotValidExeption("company doesn't exist");
        }
        company.setId(toCompare.getId());
        companiesRepository.saveAndFlush(company);
    }

	@Override
	public void deleteCompany(Company company) {
		companiesRepository.delete(company);
		System.out.println("company deleted");

	}
	
    public void deleteCompanyById(int companyId) throws NotValidExeption  {
        Company toDelete = companiesRepository.getOne(companyId);
        if (toDelete == null) {
            throw new NotValidExeption("company doesn't exist");
        }
        companiesRepository.delete(toDelete);
        System.out.println("Company deleted");
    }

	@Override
	public Company getOneCompany(int id) {
		return companiesRepository.getOne(id);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companiesRepository.findAll();
	}

	@Override
	public void addCustomer(Customer customer) throws NotValidExeption {
		List<Customer> customers = customerRepository.findAll();
		for (Customer cust : customers) {
			if (cust.getEmail().equals(customer.getEmail())) {
				throw new NotValidExeption("****customer already exist****");
			}
		}
		customerRepository.save(customer);
		System.out.println("customer added !");
	}

	@Override
	public void updateCustomer(Customer customer) throws NotValidExeption {
		int x =0;
		List<Customer> customers = customerRepository.findAll();
		for (Customer cust : customers) {
			if (cust.getId() == customer.getId()) {
				customerRepository.saveAndFlush(customer);
				 System.out.println("customer updated !");	
				 x=1;
				 break;
			}				
		}
		if (x!=1) {			
			throw new NotValidExeption("****customer id can't be changed****");					
		}
	}


	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public void deleteCustomerById(int customerID) {
		Customer todelete =  customerRepository.getOne(customerID);
		customerRepository.delete(todelete);
		System.out.println("customer deleted !");
		
	}


	@Override
	public Customer getOneCustomer(int id) {
		return customerRepository.getOne(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}


}
