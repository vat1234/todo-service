package com.mycomp.todo.service.data.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycomp.todo.service.category.data.model.CategoryEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryDataRepositoryTest {
	@Autowired
	private CategoryDataRepository categoryDataRepository;

	@Test
	public void saveCategoryTest() {
		CategoryEntity categoryEntity = CategoryEntity.builder().name("Education").build();
		CategoryEntity res = categoryDataRepository.save(categoryEntity);
		assertNotNull(res);

	}

	@Test
	public void deleteCategoryTest() {
		CategoryEntity categoryEntity = CategoryEntity.builder().name("Education").build();
		CategoryEntity res = categoryDataRepository.save(categoryEntity);
		categoryDataRepository.deleteById(res.getId());
		Optional<CategoryEntity> data = categoryDataRepository.findById(res.getId());
		assertTrue(data.isEmpty());

	}

}
