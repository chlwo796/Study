package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);

	Question findBySubjectAndContent(String subject, String content);

	List<Question> findBySubjectLike(String subject);
	
	List<Question> findByCreateDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
	
	List<Question> findByContentLike(String subject);
	
	Page<Question> findAll(Pageable pageable);
}