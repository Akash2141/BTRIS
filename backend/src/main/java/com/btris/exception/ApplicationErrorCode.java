package com.btris.exception;

import lombok.Getter;

@Getter
public enum ApplicationErrorCode {
	
	BAD_REQUEST("400",400),
	FORBIDDEN("403",403),
	NOT_FOUND("404",404),
	CONFLICT("409",409),
	INTERNAL_SERVER_ERROR("500",500);
	
	private final int httpCode;
	private final String applicationCode;
	ApplicationErrorCode(String applicationCode,int httpCode){
		this.applicationCode=applicationCode;
		this.httpCode=httpCode;
	}

}
