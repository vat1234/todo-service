package com.mycomp.todo.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.todo.service.category.data.model.CategoryEntity;

/**
 * 
 * @author Varsha T
 *
 */
public interface CategoryDataRepository extends JpaRepository<CategoryEntity, Long> {

}
