package com.codewithraushan.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithraushan.springcloud.model.Coupon;
import com.codewithraushan.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	CouponRepo repo;

	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		if (coupon == null) {
			throw new IllegalArgumentException("coupon is required");
		}
		return repo.save(coupon);
		
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		if (code == null) {
			throw new IllegalArgumentException("code is required");
		}
		return repo.findByCode(code);
		
	}
}














