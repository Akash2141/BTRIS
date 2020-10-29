package com.btris.exception;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class ApplicationError {
	
	private final String code;
	private Serializable[] args;
	
	public ApplicationError(String code,Serializable[] args) {
		this.code=code;
		this.args=args;
	}
	
	public ApplicationError(String code) {
		this.code=code;
	}

}
