package com.mycomp.todo.service.category.controller;

import static com.mycomp.todo.service.constants.UserConstants.USER_ID;

import javax.annotation.Resource;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.todo.service.category.service.CategoryService;
import com.mycomp.todo.service.model.Category;
import com.mycomp.todo.service.response.CategoryServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */
@RestController
public class CategoryServiceController {
	@Resource(name = "categoryService")
	private CategoryService categoryService;

	@RequestMapping(value = "/v1/categories", method = RequestMethod.POST)
	public ResponseEntity<CategoryServiceResponse> createCategory(@RequestBody Category category) {
		String s = MDC.get(USER_ID);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoryService.createCategory(category, Long.parseLong(s)));

	}

	@RequestMapping(value = "/v1/categories/{categoryid}", method = RequestMethod.DELETE)
	public ResponseEntity<CategoryServiceResponse> deleteCategory(@PathVariable("categoryid") final long categoryId) {
		String s = MDC.get(USER_ID);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoryService.deleteCategory(categoryId, Long.parseLong(s)));

	}

}
