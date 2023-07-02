package com.demospring.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demospring.entity.CategoryEntity;
import com.demospring.repository.CategoryRepository;
import com.demospring.service.ICategoryservice;

@Service
public class CategoryService implements ICategoryservice{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Map<String, String> findAll() {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

}
