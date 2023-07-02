package com.demospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demospring.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
