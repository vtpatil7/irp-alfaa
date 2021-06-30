package com.irp.alfaa.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.irp.alfaa.registration.AlfaaLoginRequest;
import com.irp.alfaa.registration.RegistrationRequest;
import com.irp.alfaa.service.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AlfaaController {

/*		
			private RegistrationService registrationService;
			
			@RequestMapping(value = "api/alfaaLogin")
			@PostMapping
			public String register(@RequestBody AlfaaLoginRequest request) {
				
				System.out.println("login api done");
				return registrationService.login(request);
			
	}
*/
}
