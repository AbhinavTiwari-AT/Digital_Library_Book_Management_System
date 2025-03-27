package com.abhinav.digital_library.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleStatus(HttpMessageNotReadableException exception)
	{
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    		             .body("Invalid Input!! please enter AVAILABLE or CHECKED_OUT");
	}
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(exception.getMessage());
    }
    
}
