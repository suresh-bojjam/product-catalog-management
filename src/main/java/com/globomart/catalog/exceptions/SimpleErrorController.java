package com.globomart.catalog.exceptions;

import org.springframework.boot.web.servlet.error.ErrorController;

public class SimpleErrorController implements ErrorController{

	private ErrorDetails ex= null;
	
	public SimpleErrorController() {
		
	}
	
	public SimpleErrorController(String errorMessage,int errorCode,int status) {
		ex=new ErrorDetails(errorMessage,errorCode,status);
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
