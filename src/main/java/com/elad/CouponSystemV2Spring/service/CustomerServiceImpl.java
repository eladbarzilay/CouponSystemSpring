package com.elad.CouponSystemV2Spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.beans.Customer;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;

import lombok.Getter;


@Service
@Scope("prototype")
@Getter
public class CustomerServiceImpl extends ClientService implements CustomerService {

	private int customerID;
	
    public CustomerServiceImpl() {
        super();
    }
//	public void setCustomerId(int customerID) {
//		this.customerID = customerID;
//
//	}
	
//	@Override
//	public boolean login(String email, String password) throws NotValidExeption {
//		Customer customer = customerRepository.getOne(customerID);
//		if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
//			System.out.println("hello " + customer.getFirstName()+" "+customer.getLastName());
//			return true;
//		}
//		System.out.println("password or email is wrong");
//		return false;
//	}
	
    @Override
    public boolean login(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            this.customerID = customer.getId();
            System.out.println("welcome "+customer.getFirstName()+" "+customer.getLastName());
            return customerRepository.existsByEmailAndPassword(email, password);
        }
        return false;
    }

//	@Override
//	public void purchaseCoupon(Coupon coupon) throws NotValidExeption, ParseException {
//		Customer customer = customerRepository.getOne(customerID);
//		List<Coupon>customerCoupons = customer.getCoupons();
//		if (coupon.getAmount()<=0 ) {
//			throw new NotValidExeption("coupon amount is 0");
//		}
//		for (int i = 0; i < customerCoupons.size(); i++) {
//			if (customerCoupons.get(i).equals(coupon)) {
//				throw new NotValidExeption("coupon already exist");
//			}
//			if (coupon.getEndDate().before(DateUtills.getDate(16, 5, 2021))) {
//				throw new NotValidExeption("coupon is expired");
//			}
//			customerCoupons.add(coupon);
//			coupon.setAmount(coupon.getAmount()-1);
//			couponsRepository.saveAndFlush(coupon);
//			customer.setCoupons(customerCoupons);
//			customerRepository.saveAndFlush(customer);
//			System.out.println("coupon added to customer");
//			break;
//		}
//		if (customerCoupons.size() == 0) {
//			coupon.setCompanyID(customerID);
//			customerCoupons.add(coupon);
//			customer.setCoupons(customerCoupons);
//			customerRepository.saveAndFlush(customer);
//			System.out.println("coupon added to customer");
//		}
//
//	}
    public void purchaseCoupon(int couponId) throws NotValidExeption {
        Customer customer = customerRepository.findById(customerID);
        List<Coupon> couponList = customer.getCoupons();
        for (Coupon p : couponList) {
            if (couponId == p.getId()) {
                throw new NotValidExeption("Coupon was previously purchase");
            }
        }
        Coupon coupon = couponsRepository.getOne(couponId);
        if (coupon.getEndDate().getTime() - new Date().getTime() < 0) {
            throw new NotValidExeption("Coupon is no longer valid");
        }

        if (coupon.getAmount() == 0) {
            throw new NotValidExeption("Sorry no more coupons left");
        }

        coupon.setAmount(coupon.getAmount() - 1);
        couponList.add(coupon);
        customer.setCoupons(couponList);
        customerRepository.save(customer);
    }

	@Override
	public List<Coupon> getAllCustomerCoupons() {
		Customer customer = customerRepository.getOne(customerID);
		
		return customer.getCoupons();
	}

	@Override
	public List<Coupon> getCustomerCouponsByCategory(Category category) {
		Customer customer = customerRepository.getOne(customerID);
		List<Coupon> customerCoupons = customer.getCoupons();
		List<Coupon>res = new ArrayList<>();
		for (Coupon coup : customerCoupons) {
			if (coup.getCategory().equals(category)) {
				res.add(coup);
			}
		}
		return res;
	}

	@Override
	public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
		Customer customer = customerRepository.getOne(customerID);
		List<Coupon> customerCoupons = customer.getCoupons();
		List<Coupon>res = new ArrayList<>();
		for (Coupon coup : customerCoupons) {
			if (coup.getPrice() < maxPrice) {
				res.add(coup);
			}
		}
		return res;
	}

	@Override
	public void deleteCustomerCoupon(int id) {
		couponsRepository.deleteById(id);

	}

	@Override
	public Customer getCustomerDetails() {
		Customer customer = customerRepository.getOne(customerID);
		return customer;
	}

	public List<Coupon> getAllCoupons() {
		
		return couponsRepository.findAll();
	}



}
