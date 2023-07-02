package com.demospring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.demospring.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findById(long id);
	NewDTO save(NewDTO dto);
	void delete(long[] ids);
}
