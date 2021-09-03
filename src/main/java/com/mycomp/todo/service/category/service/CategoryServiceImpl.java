package com.mycomp.todo.service.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.todo.service.category.data.model.CategoryEntity;
import com.mycomp.todo.service.data.model.ToDoEntity;
import com.mycomp.todo.service.data.repository.CategoryDataRepository;
import com.mycomp.todo.service.data.repository.ToDoDataRepository;
import com.mycomp.todo.service.exception.ToDoServiceException;
import com.mycomp.todo.service.model.Category;
import com.mycomp.todo.service.response.CategoryServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDataRepository categoryDataRepository;
	@Autowired
	private ToDoDataRepository toDoDataRepository;

	@Autowired
	public CategoryServiceImpl() {

	}

	@Override
	public CategoryServiceResponse createCategory(Category category, long userId) {
		CategoryEntity categoryEntity = CategoryEntity.builder().name(category.getName()).userId(userId).build();

		try {
			CategoryEntity res = categoryDataRepository.save(categoryEntity);
			return CategoryServiceResponse.builder().name(category.getName()).id(res.getId())
					.msg("Category creation succesful.").build();
		} catch (Exception ex) {
			throw new ToDoServiceException("Unable to create category " + category.getName(), ex);
		}

	}

	@Override
	public CategoryServiceResponse deleteCategory(long categoryId, long userId) {
		try {
			//TODO: optimize 
			List<ToDoEntity> toDoEntities = toDoDataRepository.findByCategoryId(categoryId, userId);

			if (null != toDoEntities) {
				toDoDataRepository.deleteAll(toDoEntities);
			}
			categoryDataRepository.deleteById(categoryId);

		} catch (Exception ex) {
			throw new ToDoServiceException("Unable to delete category ", ex);
		}
		return CategoryServiceResponse.builder().msg("Category deletion successful.").id(categoryId).build();
	}

}
