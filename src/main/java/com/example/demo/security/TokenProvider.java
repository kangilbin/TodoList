package com.example.demo.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.controller.UserController;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {
	private static final String SECRET_KEY = 'NMA8JPctFuna59f5';
	
	public String create(UserEntity userEntity) {
		// 기한은 지금부터 1일로 설정
		Data expiryDate = Date.from(
				Instant.now()
				.plus(1, ChronoUnit.DAYS));
		/*
		 *  { // header
		 *  	"alg" : "HS512"
		 *  },
		 *  { // payload
		 *  	"sub" : "40288093784915d201784916a40c0001",
		 *  	"
		 * 
		 */
		return Jwts.builder();
	}
}
