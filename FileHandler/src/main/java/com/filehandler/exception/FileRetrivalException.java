package com.filehandler.exception;

public class FileRetrivalException extends RuntimeException {
	
	
	private static final long serialVersionUID = 234238632426L;

	public FileRetrivalException() {
		super();
	}
	
	public FileRetrivalException(String msg) {
		super(msg);
	}
	
	public FileRetrivalException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
