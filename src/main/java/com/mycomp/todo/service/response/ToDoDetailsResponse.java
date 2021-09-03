package com.mycomp.todo.service.response;

import java.util.List;

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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ToDoDetailsResponse {
	private List<ToDoDetails> toDetails;
	private int currentPage;
	private long totalItems;
	private int totalPages;

}
