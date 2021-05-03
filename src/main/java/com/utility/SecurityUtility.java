 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import java.security.SecureRandom;
import java.util.Random;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author PC
 */
@Component
public class SecurityUtility {
	private static final String SALT = "salt"; // Salt should be protected carefully
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPassword() {
		String SALTCHARS = "ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		
		while (salt.length()<18) {
			int index= (int) (rnd.nextFloat()*SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}
}

    

