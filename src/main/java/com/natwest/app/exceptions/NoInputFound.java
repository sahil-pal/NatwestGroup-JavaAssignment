package com.natwest.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NoInputFound extends RuntimeException {

	private String message;
	
	public NoInputFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
