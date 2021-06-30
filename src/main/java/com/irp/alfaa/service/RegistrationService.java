package com.irp.alfaa.service;

import java.sql.SQLException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.irp.alfaa.exception.ApiRequestException;
import com.irp.alfaa.model.AppUser;
import com.irp.alfaa.model.AppUserRole;
import com.irp.alfaa.registration.AlfaaLoginRequest;
import com.irp.alfaa.registration.EmailValidator;
import com.irp.alfaa.registration.RegistrationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

		private final EmailValidator emailValidator;
		private final AppUserService appUserService;
		private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
		public String register(RegistrationRequest request) {
		// TODO Auto-generated method stub
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new ApiRequestException("Given Email Not Valid");
		}
		
		return appUserService.signUpUser(new AppUser(
				request.getFirstName(),
				request.getLastName(),
				request.getEmail(),
				request.getPassword(),
				request.getAppUserRole()));
	}
		
		public boolean login(AlfaaLoginRequest loginRequest)  {
			// TODO Auto-generated method stub
			UserDetails isValidEmail = appUserService.loadUserByUsername(loginRequest.getEmail());
			String passwordIP = loginRequest.getPassword();
			if(!bCryptPasswordEncoder.matches(passwordIP, isValidEmail.getPassword())) {
				
				throw new ApiRequestException("Password does not match");
				//return true;
			}
			return true;
		}


}
