package com.irp.alfaa.service;

import java.sql.SQLException;
import java.util.function.Supplier;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.irp.alfaa.exception.ApiRequestException;
import com.irp.alfaa.model.AppUser;
import com.irp.alfaa.repo.AppUserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
	
	private final static String USER_NOT_FOUND = "user with email %s not found";
	private final AppUserRepo appUserRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public String signUpUser(AppUser appUser) {
		boolean userExists = appUserRepo.findByEmail(appUser.getEmail()).isPresent();
		
		if(userExists) {
			throw new ApiRequestException("Email already taken");
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(appUser.getPassword());
		
		appUser.setPassword(encodePassword);
		
		appUserRepo.save(appUser);
		
		//TODO: send confirmation token
		
		
		return "Works! - signUp";
	}


	@Override
	public UserDetails loadUserByUsername(String email) {
		// TODO Auto-generated method stub
		return appUserRepo.findByEmail(email).orElseThrow(() -> new ApiRequestException("No User Found!"));
	}



}
