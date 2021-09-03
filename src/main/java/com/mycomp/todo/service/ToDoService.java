package com.mycomp.todo.service;

import java.util.Date;

import com.mycomp.todo.service.data.model.Status;

/**
 * 
 * @author Varsha T
 *
 */

import com.mycomp.todo.service.model.ToDo;
import com.mycomp.todo.service.response.ToDoDetailsResponse;
import com.mycomp.todo.service.response.ToDoServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */
public interface ToDoService {
	ToDoServiceResponse addToDo(long categoryId, ToDo toDo);

	ToDoServiceResponse updateToDo(long categoryId, ToDo toDo, long toDoId);

	ToDoDetailsResponse findByStatusAndCategoryId(long categoryId, long userId, Status status, int page, int size, Date fromDate,
			Date toDate);

}
