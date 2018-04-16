package com.globomart.catalog.exceptions;

import org.springframework.http.HttpStatus;

public class GloboMartException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorDetails ex=null;
		
	public ErrorDetails getEx() {
		return ex;
	}

	public void setEx(ErrorDetails ex) {
		this.ex = ex;
	}

	GloboMartException(String errorMessage){
		super(errorMessage);
	}
	
	public GloboMartException(String errorMessage,int errorCode,int status){
		super(errorMessage);
		ex=new ErrorDetails(errorMessage,
		        1000,HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
