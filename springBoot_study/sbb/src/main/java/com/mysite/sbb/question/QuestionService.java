package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;

//  검색기능 추가(기존메소드 수정)
//	public List<Question> getList() {
//		return this.questionRepository.findAll();
//	}
	public Page<Question> getList(int page, String kw) {
		// 페이징 기능 추가
		// 검색어를 의미하는 매개변수 kw를 getList에 추가
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts));
		// kw값으로 Specification 객체를 생성하여 findAll 메소드 호출시 전달
		Specification<Question> spec = search(kw);
		return this.questionRepository.findAll(spec, pageable);
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

	private Specification<Question> search(String kw) {
		return new Specification<>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true); // 중복 제거
				Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);
				Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
				Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);

				return cb.or(cb.like(q.get("subject"), "%" + kw + "%"), // 제목
						cb.like(q.get("content"), "%" + kw + "%"), // 내용
						cb.like(u1.get("username"), "%" + kw + "%"), // 질문작성자
						cb.like(a.get("content"), "%" + kw + "%"), // 답변 내용
						cb.like(u2.get("username"), "%" + kw + "%")); // 답변작성자

			}
		};
	}
}