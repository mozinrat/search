package com.erecyclingcorps.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author parora
 **/

public class PasswordCreator {

	public static void main(String args[]) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("Password1");
		System.out.println(hashedPassword);
	}

}
