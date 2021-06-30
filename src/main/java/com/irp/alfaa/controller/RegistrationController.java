package com.irp.alfaa.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.irp.alfaa.registration.AlfaaLoginRequest;
import com.irp.alfaa.registration.RegistrationRequest;
import com.irp.alfaa.service.RegistrationService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
public class RegistrationController {
	
		private RegistrationService registrationService;
		
		
		@GetMapping(path = "/")
		public String hello() {
			
			return "Hello API";
		
		}
		
		@RequestMapping(path = "api/alfaa/registration")
		@PostMapping
		public @ResponseBody ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
			System.out.println("login registration done");
			return ResponseEntity.status(HttpStatus.OK).body(registrationService.register(request));
		}
		
		@RequestMapping(path = "api/alfaa/login")
		@GetMapping
		public @ResponseBody ResponseEntity<Boolean> register(@RequestBody AlfaaLoginRequest request) throws SQLException {
			
			System.out.println("login api done");
			return ResponseEntity.status(HttpStatus.OK).body(registrationService.login(request));
		
}
}
