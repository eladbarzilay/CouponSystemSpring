package com.elad.CouponSystemV3Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elad.CouponSystemV3Spring.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	  Customer findByEmail(String email);

	    Customer findById(int id);

	    boolean existsByEmailAndPassword(String email, String password);
}
