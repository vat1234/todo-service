package com.mycomp.todo.service.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycomp.todo.service.model.ToDoDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Varsha T
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoServiceResponse {
	private String msg;
	private long id;
	private ToDoDetails toDoDetails;

}
