package com.mycomp.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycomp.todo.service.category.data.model.CategoryEntity;
import com.mycomp.todo.service.data.model.Status;
import com.mycomp.todo.service.data.model.ToDoEntity;
import com.mycomp.todo.service.data.repository.CategoryDataRepository;
import com.mycomp.todo.service.data.repository.ToDoDataRepository;
import com.mycomp.todo.service.exception.ToDoServiceException;
import com.mycomp.todo.service.model.ToDo;
import com.mycomp.todo.service.model.ToDoDetails;
import com.mycomp.todo.service.response.ToDoDetailsResponse;
import com.mycomp.todo.service.response.ToDoServiceResponse;

/**
 * 
 * @author Varsha T
 *
 */
@Service("todoservice")
public class ToDoServiceImpl implements ToDoService {
	@Autowired
	private ToDoDataRepository toDoDataRepository;
	@Autowired
	private CategoryDataRepository categoryDataRepository;

	@Autowired
	public ToDoServiceImpl() {

	}

	@Override
	public ToDoServiceResponse addToDo(long categoryId, ToDo toDo) {
		try {
			CategoryEntity categoryEntity = categoryDataRepository.findById(categoryId).get();
			ToDoEntity toDoEntity = ToDoEntity.builder().name(toDo.getName()).categoryEntity(categoryEntity)
					.dateTime(toDo.getDateTime()).status(toDo.getStatus()).description(toDo.getDescription()).build();
			ToDoEntity res = toDoDataRepository.save(toDoEntity);
			return ToDoServiceResponse.builder().id(res.getId()).msg("Created successfully.").build();
		} catch (Exception ex) {
			throw new ToDoServiceException("Failed to create Todo ", ex);

		}

	}

	@Override
	public ToDoServiceResponse updateToDo(long categoryId, ToDo toDo, long toDoId) {

		try {
			CategoryEntity categoryEntity = categoryDataRepository.findById(categoryId).get();
			ToDoEntity toDoEntity = ToDoEntity.builder().name(toDo.getName()).categoryEntity(categoryEntity)
					.dateTime(toDo.getDateTime()).status(toDo.getStatus()).description(toDo.getDescription()).id(toDoId)
					.build();

			ToDoEntity res = toDoDataRepository.save(toDoEntity);
			CategoryEntity cat = res.getCategoryEntity();
			return ToDoServiceResponse.builder().id(res.getId()).msg("Updated successfully.")
					.toDoDetails(ToDoDetails.builder().categoryId(cat.getId()).categoryName(cat.getName())
							.dateTime(res.getDateTime()).description(res.getDescription()).name(res.getName())
							.status(res.getStatus()).id(res.getId()).build())
					.build();
		} catch (Exception ex) {
			throw new ToDoServiceException("Failed to update Todo ", ex);

		}
	}

	@Override
	public ToDoDetailsResponse findByStatusAndCategoryId(long categoryId, long userId, Status status, int page,
			int size, Date fromDate, Date toDate) {
		Pageable paging = PageRequest.of(page, size);
		try {
			Page<ToDoEntity> pageToDos = toDoDataRepository.findByStatusAndCategoryId(categoryId, userId, status.name(),
					paging, fromDate, toDate);
			List<ToDoEntity> toDoEntities = new ArrayList<ToDoEntity>();
			toDoEntities = pageToDos.getContent();
			List<ToDoDetails> toDoDetails = new ArrayList<ToDoDetails>();
			for (ToDoEntity toDoEntity : toDoEntities) {
				toDoDetails.add(ToDoDetails.builder().categoryId(toDoEntity.getCategoryEntity().getId())
						.categoryName(toDoEntity.getCategoryEntity().getName()).dateTime(toDoEntity.getDateTime())
						.description(toDoEntity.getDescription()).id(toDoEntity.getId()).name(toDoEntity.getName())
						.status(toDoEntity.getStatus()).build());
			}
			return ToDoDetailsResponse.builder().toDetails(toDoDetails).currentPage(pageToDos.getNumber())
					.totalItems(pageToDos.getTotalElements()).totalPages(pageToDos.getTotalPages()).build();
		} catch (Exception exception) {
			throw new ToDoServiceException("Failed to get Todo by status ", exception);
		}

	}

}
