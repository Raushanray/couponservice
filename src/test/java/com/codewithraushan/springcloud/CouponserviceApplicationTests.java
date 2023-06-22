package com.codewithraushan.springcloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithraushan.springcloud.controllers.CouponRestController;
import com.codewithraushan.springcloud.model.Coupon;
import com.codewithraushan.springcloud.repos.CouponRepo;

@SpringBootTest
class CouponserviceApplicationTests {

	private static final String SUPERSALE = "SUPERSALE";

	@Mock
	private CouponRepo repo;

	@InjectMocks
	private CouponRestController controller;

	@Test
	public void testCreate() {
		Coupon coupon = new Coupon();
		coupon.setCode(SUPERSALE);
		when(repo.save(coupon)).thenReturn(coupon);
		Coupon couponCreate = controller.create(coupon);
		verify(repo).save(coupon);
		assertNotNull(couponCreate);
		assertEquals(SUPERSALE, coupon.getCode());

	}
}