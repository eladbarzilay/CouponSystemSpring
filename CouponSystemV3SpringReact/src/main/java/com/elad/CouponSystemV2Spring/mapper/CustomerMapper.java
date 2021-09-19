package com.elad.CouponSystemV2Spring.mapper;

import org.springframework.stereotype.Component;

import com.elad.CouponSystemV2Spring.beans.Customer;
import com.elad.CouponSystemV2Spring.dto.entities.CustomerDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerDto> {

    @Override
    public Customer toDao(CustomerDto customerDto) {
        return Customer.builder().
                firstName(customerDto.getFirstName()).
                lastName(customerDto.getLastName()).
                email(customerDto.getEmail()).
                password(customerDto.getPassword()).
                build();
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        return CustomerDto.builder().
                firstName(customer.getFirstName()).
                lastName(customer.getLastName()).
                email(customer.getEmail()).
                password(customer.getPassword()).
                build();
    }

    @Override
    public List<Customer> toDaoList(List<CustomerDto> customerDtos) {
        return customerDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> toDtoList(List<Customer> customers) {
        return customers.stream().map(this::toDto).collect(Collectors.toList());
    }
}