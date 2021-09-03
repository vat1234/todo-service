package com.mycomp.todo.service.model;

import java.util.Date;

import com.mycomp.todo.service.data.model.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Varsha T
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ToDoDetails {
	private String name;
	private String description;
	private long categoryId;
	private String categoryName;
	private Date dateTime;
	private Status status;
	private long id;

}
