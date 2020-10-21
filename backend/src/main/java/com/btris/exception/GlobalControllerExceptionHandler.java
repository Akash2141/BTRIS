package com.btris.exception;

import java.io.Serializable;
import java.nio.file.AccessDeniedException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApplicationError> handleConflict(ApplicationException e){
		ApplicationErrorCode code=Optional.ofNullable(e.getCode()).orElse(ApplicationErrorCode.INTERNAL_SERVER_ERROR);
		String args=Stream.of(e.getArgs())
				.filter(Objects::nonNull)
				.map(Serializable::toString)
				.collect(Collectors.joining(", "));
		log.error("{} - {} - {}",code.name(),args,e.getMessage(),e);
		ApplicationError applicationError=new ApplicationError(code.getApplicationCode(),e.getArgs());
		return new ResponseEntity<>(applicationError,HttpStatus.valueOf(code.getHttpCode()));
	}
	
	@ExceptionHandler({ConstraintViolationException.class,HttpMessageNotReadableException.class,MethodArgumentNotValidException.class})
	public ResponseEntity<ApplicationError> handleBadRequest(Exception t){
		log.error(t.getMessage(),t);
		ApplicationError applicationError=new ApplicationError(ApplicationErrorCode.BAD_REQUEST.getApplicationCode());
		return new ResponseEntity<ApplicationError>(applicationError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({AccessDeniedException.class})
	public ResponseEntity<ApplicationError> handleAccessDenied(Exception t){
		log.error(t.getMessage(),t);
		ApplicationError applicationError=new ApplicationError(ApplicationErrorCode.FORBIDDEN.getApplicationCode());
		return new ResponseEntity<ApplicationError>(applicationError,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApplicationError> handleConflict(Throwable t){
		log.error(t.getMessage(),t);
		ApplicationError applicationError=new ApplicationError(ApplicationErrorCode.INTERNAL_SERVER_ERROR.getApplicationCode());
		return new ResponseEntity<ApplicationError>(applicationError,HttpStatus.INTERNAL_SERVER_ERROR)
	}
	
	

}
