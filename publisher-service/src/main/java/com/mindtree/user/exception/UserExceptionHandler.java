package com.mindtree.user.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.user.exception.entity.ApiError;

@RestControllerAdvice
public class UserExceptionHandler {

		@ExceptionHandler(NullCheckException.class)
		public ResponseEntity<ApiError> nullCheckExceptionHandler(NullCheckException nullCheckException){
			ApiError error=new ApiError(404, nullCheckException.getMessage(), new Date());
			return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ApiError> globalExceptionHandler(Exception exception){
			ApiError error=new ApiError(404, exception.getMessage(), new Date());
			return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
}
