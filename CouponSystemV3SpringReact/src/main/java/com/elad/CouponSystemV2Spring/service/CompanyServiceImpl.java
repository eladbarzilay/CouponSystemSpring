package com.elad.CouponSystemV2Spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.elad.CouponSystemV2Spring.beans.Category;
import com.elad.CouponSystemV2Spring.beans.Company;
import com.elad.CouponSystemV2Spring.beans.Coupon;
import com.elad.CouponSystemV2Spring.exeptions.NotValidExeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Scope("prototype")
@RequiredArgsConstructor
@Getter
public class CompanyServiceImpl extends ClientService implements CompanyService {

	private int companyID;

	public void setCompanyId(int companyID) {
		this.companyID = companyID;

	}

//	@Override
//	public boolean login(String email, String password) throws NotValidExeption {
//		Company company = companiesRepository.getOne(companyID);
//		if (company.getEmail().equals(email) && company.getPassword().equals(password)) {
//			System.out.println("hello " + company.getName());
//			return true;
//		}
//		System.out.println("password or email is wrong");
//		return false;
//	}
    @Override
    public boolean login(String email, String password) {
        Company company = companiesRepository.findByEmail(email);
        if (company != null) {
            this.companyID = company.getId();
            System.out.println("welcom "+company.getName());
            return companiesRepository.existsByEmailAndPassword(email, password);
        }
        return false;
    }

	@Override
	public void addCompanyCoupon(Coupon coupon) {
		Company company = companiesRepository.getOne(companyID);
		List<Coupon> companyCoupons = company.getCoupons();

		for (int i = 0; i < companyCoupons.size(); i++) {
			if (companyCoupons.get(i).getTitle().equals(coupon.getTitle())
					&& companyCoupons.get(i).getCompanyID() == companyID) {
				System.out.println("no no ");

			} else {
				coupon.setCompanyID(companyID);
				companyCoupons.add(coupon);
				company.setCoupons(companyCoupons);
				companiesRepository.saveAndFlush(company);
				System.out.println("coupon added to company");
				break;
			}

		}
		if (companyCoupons.size() == 0) {
			coupon.setCompanyID(companyID);
			companyCoupons.add(coupon);
			company.setCoupons(companyCoupons);
			companiesRepository.saveAndFlush(company);
			System.out.println("coupon added to company");
		}


	}

	@Override
	public void updateCompanyCoupon(Coupon coupon) throws NotValidExeption {
		Company company = companiesRepository.getOne(companyID);
		List<Coupon> companyCoupons = company.getCoupons();

		for (Coupon coup : companyCoupons) {
			if (coup.getId() != coupon.getId() || coup.getCompanyID() != coupon.getCompanyID()) {
				throw new NotValidExeption("cant change id or company id");
			}
			
		}
		couponsRepository.saveAndFlush(coupon);
		System.out.println("coupon updated!");
	}

	@Override
	public void deleteCompanyCoupon(Coupon coupon) {
		
		couponsRepository.delete(coupon);

	}
	
    public void deleteCompanyCouponById(int couponId) throws NotValidExeption {
        Coupon toDelete = couponsRepository.getOne(couponId);
        if (toDelete != null) {
            couponsRepository.deleteById(toDelete.getId());
        } else {
            throw new NotValidExeption("Coupon doesn't exist and can't be deleted");
        }
    }

	@Override
	public Coupon getOneCompanyCoupon(int id) {
		Coupon coupon = null;
		Company company = companiesRepository.getOne(companyID);
		List<Coupon> companyCoupons = company.getCoupons();
		for (Coupon coup : companyCoupons) {
			if (coup.getId() == id) {
				coupon = coup;
				break;
			}
		}
		return coupon;
	}

	@Override
	public List<Coupon> getAllCompanyCoupons() {
		Company company = companiesRepository.getOne(companyID);
		return company.getCoupons();
	}

	@Override
	public List<Coupon> getAllCouponsByCategory(Category category) {
		Company company = companiesRepository.getOne(companyID);
		List<Coupon> companyCoupons = company.getCoupons();
		List<Coupon>res = new ArrayList<>();
		for (Coupon coup : companyCoupons) {
			if (coup.getCategory().equals(category)) {
				res.add(coup);
			}
		}
		return res;
	}

	@Override
	public List<Coupon> getAllCoupnsByMaxPrice(double maxPrice) {
		Company company = companiesRepository.getOne(companyID);
		List<Coupon> companyCoupons = company.getCoupons();
		List<Coupon>res = new ArrayList<>();
		for (Coupon coup : companyCoupons) {
			if (coup.getPrice() < maxPrice) {
				res.add(coup);
			}
		}
		return res;
	}

	@Override
	public Company getCompanyDetails() {
		Company company = companiesRepository.getOne(companyID);
		return company;
	}

}
