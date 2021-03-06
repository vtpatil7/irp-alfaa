package com.irp.alfaa.registration;

import com.irp.alfaa.model.AppUserRole;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
	
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;
	private final AppUserRole appUserRole;
	
	

}
