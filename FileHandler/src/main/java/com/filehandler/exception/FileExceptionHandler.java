package com.filehandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FileExceptionHandler {

	@ExceptionHandler({FileException.class, FileRetrivalException.class})
	public final ResponseEntity<String> handleException(Exception ex, WebRequest request) {
		
		if(ex instanceof FileException) {
			
			return new ResponseEntity("Failed to save the uploaded file", HttpStatus.INTERNAL_SERVER_ERROR);
			
		} else {
			
			return new ResponseEntity("Failed to retrive the metadata of the file", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
}
