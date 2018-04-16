package com.globomart.catalog.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"errorMessage",
"httpStatus",
"errorCode"
})
public class ErrorDetails {
	
	@JsonProperty("errorMessage")
	private String errorMessage=null;
	
	@JsonProperty("httpStatus")
	private int httpStatus;

	@JsonProperty("errorCode")
	private int errorCode;
	
	public ErrorDetails(String errorMessage,int httpStatus, int errorCode){
		this.errorCode=errorCode;
		this.httpStatus=httpStatus;
		this.errorMessage=errorMessage;
	}
}
