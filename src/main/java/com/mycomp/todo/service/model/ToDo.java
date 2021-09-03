package com.mycomp.todo.service.model;

import java.util.Date;

import com.mycomp.todo.service.data.model.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Varsha T
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
	private String name;
	private String description;
	private Date dateTime;
	private Status status;

}
