package com.sociopool.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	/**
	 * Catches CustomException thrown by controller methods.
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> errorHandler(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> invalidPayload(MethodArgumentNotValidException exception) {
		String errorMessage = "";
		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			errorMessage += error.getDefaultMessage() + " \n";
		}
		return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
