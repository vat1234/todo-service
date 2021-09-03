package com.mycomp.todo.service.data.repository;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycomp.todo.service.category.data.model.CategoryEntity;
import com.mycomp.todo.service.data.model.Status;
import com.mycomp.todo.service.data.model.ToDoEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ToDoDataRepositoryTest {

	@Autowired
	private ToDoDataRepository toDoDataRepository;
	@Autowired
	private CategoryDataRepository categoryDataRepository;

	@Test
	public void saveToDoTest() throws ParseException {
		CategoryEntity categoryEntity = CategoryEntity.builder().name("Education").userId(1L).id(1L).build();
		CategoryEntity res = categoryDataRepository.save(categoryEntity);
		ToDoEntity toDoEntity = ToDoEntity.builder().categoryEntity(res)
				.dateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-03")).description("Course").name("JAVA")
				.status(Status.INITIAL).build();
		ToDoEntity tores = toDoDataRepository.save(toDoEntity);
		assertNotNull(tores);

	}

	@Test
	public void findwhenCategoryIDUSerAndStatusAndDatePassed() throws ParseException {
		Pageable paging = PageRequest.of(0, 1);
		CategoryEntity categoryEntity = CategoryEntity.builder().name("Education").userId(1L).id(1L).build();
		CategoryEntity res = categoryDataRepository.save(categoryEntity);
		ToDoEntity toDoEntity = ToDoEntity.builder().categoryEntity(res)
				.dateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-03")).description("Course").name("JAVA")
				.status(Status.INITIAL).build();
		toDoDataRepository.save(toDoEntity);

		ToDoEntity toDoEntity1 = ToDoEntity.builder().categoryEntity(res)
				.dateTime(new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-03")).description("Course").name("DB")
				.status(Status.STARTED).build();
		toDoDataRepository.save(toDoEntity1);
		Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-03");
		Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-10");
		Page<ToDoEntity> toDoEntities =  toDoDataRepository.findByStatusAndCategoryId(1L, 1L, null, paging, fromDate, toDate);
		List<ToDoEntity> toDoEntities2 =  toDoEntities.getContent();
		assertNotNull(toDoEntities2);
	}

}
