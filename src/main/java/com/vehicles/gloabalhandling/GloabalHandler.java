package com.vehicles.gloabalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicles.customexception.BrandNotFoundException;
import com.vehicles.customexception.IdNotFoundException;

@RestControllerAdvice
public class GloabalHandler {
	
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandle() {
		return new ResponseEntity<Object>("Brand not Available",HttpStatus.BAD_REQUEST) ;
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> idHandle() {
		return new ResponseEntity<Object>("Id Not Available", HttpStatus.BAD_REQUEST);
	}
}
