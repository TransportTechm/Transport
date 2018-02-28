package com.techm.transport.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date().toString(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(TransportException.class)
	public final ResponseEntity<ErrorDetails> handleNotFoundException(TransportException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date().toString(), ex.getMessage(),
				request.getDescription(false));
		HttpStatus httpStatus = ex.getHttpStatus();
		return new ResponseEntity<>(errorDetails, httpStatus);
	}
}
