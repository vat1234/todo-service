package com.mycomp.todo.service.category.service;

import com.mycomp.todo.service.model.Category;
import com.mycomp.todo.service.response.CategoryServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */
public interface CategoryService {
	CategoryServiceResponse createCategory(Category category, long userId);

	CategoryServiceResponse deleteCategory(long categoryId, long userId);

}
