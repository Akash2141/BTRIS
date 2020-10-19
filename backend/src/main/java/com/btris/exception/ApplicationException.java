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
}
