package com.mysite.sbb.answer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	List<Answer> findByIdBetween(int i, int j);
	
	List<Answer> findByContentLike(String a);

	List<Answer> findByIdIn(int[] a);
}