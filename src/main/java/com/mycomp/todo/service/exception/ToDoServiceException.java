package com.mycomp.todo.service.exception;

/**
 * 
 * @author Varsha T
 *
 */
public class ToDoServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToDoServiceException(String message) {
		super(message);
	}

	public ToDoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
