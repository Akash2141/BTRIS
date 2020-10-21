package com.btris.exception;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

	private final ApplicationErrorCode code;
	private Serializable[] args;

	public ApplicationException(String message, Throwable cause, ApplicationErrorCode code, Serializable... args) {
		super(message, cause);
		this.code = code;
		this.args = args;
	}
	
	public ApplicationException(String message,ApplicationErrorCode code, Serializable... args) {
		super(message);
		this.code=code;
		this.args=args;
	}
	
	public ApplicationException(String message,ApplicationErrorCode code) {
		super(message);
		this.code=code;
	}
	
	public ApplicationException(ApplicationErrorCode code) {
		this.code=code;
		
	}
	
	public Serializable[] args() {
		if(args==null) {
			args=new Serializable[0];
		}
		return args;
	}
	
	public static ApplicationException badRequest() {
		return new ApplicationException(ApplicationErrorCode.BAD_REQUEST);
	}
}
