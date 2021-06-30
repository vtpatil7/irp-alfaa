package com.irp.alfaa.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = {ApiRequestException.class})//with this apirequestException will be fed as a input variale to method
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		//1.create payload conatin detail
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ApiException apiException = new ApiException(e.getMessage(),false, badRequest,ZonedDateTime.now(ZoneId.of("Z")));
		
		//2. return response entity
		return new ResponseEntity<>(apiException,badRequest);
	}
}
