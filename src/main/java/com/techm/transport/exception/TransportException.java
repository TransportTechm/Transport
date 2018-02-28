package com.techm.transport.exception;

import org.springframework.http.HttpStatus;

public class TransportException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	HttpStatus httpStatus =null;
	
	public TransportException(HttpStatus httpStatus){
		super();
		this.httpStatus=httpStatus;
	}
	public TransportException(String exception, HttpStatus httpStatus){
		super(exception);
		this.httpStatus=httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
