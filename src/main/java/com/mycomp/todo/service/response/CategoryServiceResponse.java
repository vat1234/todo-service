package com.mycomp.todo.service.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

/**
 * 
 * @author Varsha T
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder

public class CategoryServiceResponse {
	String name;
	long id;
	String msg;
	public CategoryServiceResponse(String name, long id, String msg) {
		super();
		this.name = name;
		this.id = id;
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
