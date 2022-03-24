package com.elad.CouponSystemV3Spring.mapper;


import org.springframework.stereotype.Component;

import com.elad.CouponSystemV3Spring.beans.Company;
import com.elad.CouponSystemV3Spring.dto.entities.CompanyDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper implements Mapper<Company, CompanyDto> {
    @Override
    public Company toDao(CompanyDto companyDto) {
        return Company.builder().
                name(companyDto.getName()).
                email(companyDto.getEmail()).
                password(companyDto.getPassword()).
                build();
    }

    @Override
    public CompanyDto toDto(Company company) {
        return CompanyDto.builder().
                name(company.getName()).
                email(company.getEmail()).
                password(company.getPassword()).
                build();
    }

    @Override
    public List<Company> toDaoList(List<CompanyDto> companyDtos) {
        return companyDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<CompanyDto> toDtoList(List<Company> companies) {
        return companies.stream().map(this::toDto).collect(Collectors.toList());
    }
}