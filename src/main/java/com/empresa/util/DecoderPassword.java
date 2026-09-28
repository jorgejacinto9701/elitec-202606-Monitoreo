package com.empresa.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DecoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "2026";
		String encodedPassword = "$2a$10$AEHJ2pMn4iZc7J3gxDAV4e6NeVIHZ/OV06Mu4WymMEez385y2OVIW";
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		
	}
}
