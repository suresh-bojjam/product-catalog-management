package com.globomart.catalog.exceptions;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GloboMartExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(GloboMartException.class)
	public final ResponseEntity<ErrorDetails> handleGloboMartServiceException(GloboMartException ex, WebRequest request){
		System.out.println("Exception Construction in Progress");
		return new ResponseEntity<>(ex.getEx(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleGenericException(GloboMartException ex, WebRequest request){
		return new ResponseEntity<>(ex.getEx(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}