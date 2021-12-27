package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRespository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
	
	@Autowired
	private TodoRespository repository;
	
	public List<TodoEntity> create(final TodoEntity entity){
		// Validations
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity Id : {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());
	}
	
	public List<TodoEntity> retrieve(final String userId){
		log.info("Entity userId : {} is find.", userId);
		return repository.findByUserId(userId);
	}
	// 리팩토링하나 메서드
	private void validate(final TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("entity cannot be null.");
		}
		
		if(entity.getUserId() == null) {
			log.warn("Unkown user.");
			throw new RuntimeException("Unknown user");
		}
	}
}
 