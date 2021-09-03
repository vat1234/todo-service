package com.mycomp.todo.service.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycomp.todo.service.data.model.ToDoEntity;

/**
 * 
 * @author Varsha T
 *
 */
public interface ToDoDataRepository extends JpaRepository<ToDoEntity, Long> {

	@Query(value = "select t.* from todo t ,categories c where c.id=t.category_id and c.id=?1 and c.user_id=?2 and t.status=?3 and t.date_time>=?4 and t.date_time<=?5", nativeQuery = true)
	Page<ToDoEntity> findByStatusAndCategoryId(long category_id, long userId, String status, Pageable pageable,
			Date fromDate, Date toDate);

	@Query(value = "select t.* from todo t ,categories c where c.id=t.category_id and c.id=?1 and c.user_id=?2", nativeQuery = true)
	List<ToDoEntity> findByCategoryId(long category_id, long userId);

}
