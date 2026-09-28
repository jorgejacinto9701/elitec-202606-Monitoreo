package com.empresa.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DecoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "2026";
		String encodedPassword = "$2a$10$UpRniOJk79kqbommNs/o7u/mQKLmarKRrjjxAvmmcHPrUaqiAreOG";
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		
	}
}
