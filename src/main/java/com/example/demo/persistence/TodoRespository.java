package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

@Repository
public interface TodoRespository extends JpaRepository<TodoEntity, String>{
	// ?1은 메서드의 매개변수의 순서 위치다.
	//@Query("select id, userId, title, done from Todo t where t.userId = ?1")
	List<TodoEntity> findByUserId(String userId);
}
