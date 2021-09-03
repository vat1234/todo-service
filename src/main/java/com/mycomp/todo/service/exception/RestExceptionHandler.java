package com.mycomp.todo.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mycomp.todo.service.response.ToDoServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ToDoServiceException.class)
	public ResponseEntity<Object> hanldeCategoryServiceException(ToDoServiceException ex, WebRequest webRequest) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ToDoServiceResponse.builder().msg(ex.getMessage()).build());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> hanldeToDoServiceException(Exception ex, WebRequest webRequest) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ToDoServiceResponse.builder().msg(ex.getMessage()).build());
	}

}
