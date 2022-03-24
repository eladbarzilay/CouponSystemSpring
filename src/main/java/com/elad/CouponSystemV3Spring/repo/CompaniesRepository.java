package com.elad.CouponSystemV3Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elad.CouponSystemV3Spring.beans.Company;

public interface CompaniesRepository extends JpaRepository<Company, Integer>{
    Company findByName(String name);
    Company findByEmail(String email);
    Company findByNameOrEmail(String name, String email);
    Company findById(int companyID);
    boolean existsByEmailAndPassword(String email, String password);
}
