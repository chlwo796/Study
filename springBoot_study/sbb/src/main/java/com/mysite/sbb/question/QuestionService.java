package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;

	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	public Question getQuestion(Integer id) {
		// id값으로 Question 데이터를 조회하는 getQuestion 메소드 추가
		Optional<Question> question = this.questionRepository.findById(id);
		// Optional 객체인 경우 inPresent 메소드로 데이터가 존재하는지 검사
		if (question.isPresent()) {
			return question.get();
		} else {
			// id값에 해당하는 Question 데이터가 없을 경우 예외처리
			throw new DataNotFoundException("question not found");
		}
	}

	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
}