package com.mycomp.todo.service;

import static com.mycomp.todo.service.constants.UserConstants.USER_ID;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.MDC;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.todo.service.data.model.Status;
import com.mycomp.todo.service.model.ToDo;
import com.mycomp.todo.service.response.ToDoDetailsResponse;
import com.mycomp.todo.service.response.ToDoServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */
@RestController
public class ToDoServiceController {
	@Resource(name = "todoservice")
	private ToDoService toDoService;

	@RequestMapping(value = "/v1/categories/{categoryid}/todo", method = RequestMethod.POST)
	public ResponseEntity<ToDoServiceResponse> addToDo(@RequestBody ToDo todo,
			@PathVariable("categoryid") Long categoryId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.addToDo(categoryId, todo));

	}

	@RequestMapping(value = "/v1/categories/{categoryid}/todo/{todoid}", method = RequestMethod.PUT)
	public ResponseEntity<ToDoServiceResponse> updateToDo(@RequestBody ToDo todo,
			@PathVariable("categoryid") Long categoryId, @PathVariable("todoid") Long todoId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.updateToDo(categoryId, todo, todoId));

	}

	@RequestMapping(value = "/v1/categories/{categoryid}", method = RequestMethod.GET)
	public ResponseEntity<ToDoDetailsResponse> getToDoByStatus(@PathVariable("categoryid") Long categoryId,
			@RequestParam(required = false) Status status, @RequestParam(defaultValue = "0", required = false) int page,
			@RequestParam(defaultValue = "1", required = false) int size,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
		String s = MDC.get(USER_ID);
		return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.findByStatusAndCategoryId(categoryId,
				Long.parseLong(s), status, page, size, fromDate, toDate));

	}

}
