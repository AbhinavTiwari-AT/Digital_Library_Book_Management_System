package com.abhinav.digital_library.Exceptions;

public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fieldName;
	Object fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
	    super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
	}
}
