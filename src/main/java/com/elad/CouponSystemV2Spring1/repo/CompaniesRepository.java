package com.elad.CouponSystemV2Spring1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elad.CouponSystemV2Spring1.beans.Company;


public interface CompaniesRepository extends JpaRepository<Company, Integer>{
    Company findByName(String name);
    Company findByEmail(String email);
    Company findByNameOrEmail(String name, String email);
    Company findById(int companyID);
    boolean existsByEmailAndPassword(String email, String password);
}
