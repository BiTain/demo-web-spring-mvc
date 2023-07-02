package com.demospring.converter;

import org.springframework.stereotype.Component;

import com.demospring.dto.NewDTO;
import com.demospring.entity.NewEntity;

@Component
public class NewConverter {

	public NewDTO toDto(NewEntity entity) {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDescrption());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setShortDescrption(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	public NewEntity toEntity(NewEntity result, NewDTO dto) {
		result.setTitle(dto.getTitle());
		result.setShortDescrption(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
}
