package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.user.SiteUser;

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

	public void create(String subject, String content, SiteUser user) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(user);
		this.questionRepository.save(q);
	}

	public Page<Question> getList(int page) {
		// 페이징 기능 추가
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}

	public void modify(Question question, String subject, String content) {
		// 수정 기능 추가
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}

	public void delete(Question question) {
		// 삭제 기능 추가
		this.questionRepository.delete(question);
	}

	public void vote(Question question, SiteUser siteUser) {
		// 추천인 저장 기능
		question.getVoter().add(siteUser);
		this.questionRepository.save(question);
	}
}