package com.demospring.converter;

import org.springframework.stereotype.Component;

import com.demospring.dto.CategoryDTO;
import com.demospring.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
}
