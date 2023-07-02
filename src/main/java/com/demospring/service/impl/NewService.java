package com.demospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demospring.converter.NewConverter;
import com.demospring.dto.NewDTO;
import com.demospring.entity.CategoryEntity;
import com.demospring.entity.NewEntity;
import com.demospring.repository.CategoryRepository;
import com.demospring.repository.NewRepository;
import com.demospring.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> newEntities = newRepository.findAll(pageable).getContent();
		for (NewEntity item : newEntities) {
			NewDTO newDTO = newConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int)newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		// TODO Auto-generated method stub
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		// TODO Auto-generated method stub
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if(dto.getId()!=null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		}else {
			 newEntity = newConverter.toEntity(dto);
			 newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id : ids) {
			newRepository.delete(id);
		}
	}

}
