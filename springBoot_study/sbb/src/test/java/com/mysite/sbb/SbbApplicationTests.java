package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerRepository answerRepository;

//	@Test
//	void contextLoads() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); // 첫번째 질문 저장
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2); // 두번째 질문 저장
//	}
//
//	@Test
//	void testJpa() {
//		// findAll() = 데이터를 조회할 때 사용하는 메소드
//		List<Question> all = this.questionRepository.findAll();
//		// assertEquals(기대값, 실제값) = 기대값과 실제값이 동일한지 확인
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}

//	@Test
//	void testJpaFindById() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if (oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}
//	   @Test
//	    void testJpa() {
//	        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//	        assertEquals(1, q.getId());
//	    }

//	    @Test
//	    void testJpa() {
//	        Question q = this.questionRepository.findBySubjectAndContent(
//	                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//	        assertEquals(1, q.getId());
//	    }
//	@Test
//	void testJpa() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}

//    @Test
//    void testJpa() {
//    	// 질문 데이터를 수정하는 테스트 코드
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());	// 값이 true인지 테스트
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);	// 데이터저장
//    }

//    @Test
//    void testJpa() {
//    	// 데이터 삭제하기 테스트
//        assertEquals(2, this.questionRepository.count());	// 총 데이터 수 리턴
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
//    }
//	@Test
//	void testJpa() {
//		// 답변 데이터 생성 후 저장
//		Optional<Question> oq = this.questionRepository.findById(6);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("답변");
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}

//    @Test
//    void testJpa() {
//    	// 답변 조회하기
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());
//    }

//	@Transactional // 해당 메소드가 종료될 떄까지 DB세션 유지
	// 없으면 question 리포지터리가 question 객체를 조회하고 나면 db세션이 끊어져 에러발생
	// 실제 서버에서는 세션이 종료되지 않으므로 같은 오류가 발생하지 않는다.
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		List<Answer> answerList = q.getAnswerList();
//
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
//	}

//	@Test
//	void testSearch() {
//		int count = 0;
//		List<Question> all = this.questionRepository.findAll();
//		for (int i = 0; i < all.size(); i++) {
//			int month = all.get(i).getCreateDate().getMonthValue();
//			if(month == 5 || month == 6) {
//				count++;
//			}
//		}
//		assertEquals(2, count);
//	}
//	@Test
//	void testSearch() {
//		// 날짜검색
//		List<Question> qList = this.questionRepository.findByCreateDateBetween(LocalDateTime.of(2023, 04, 01, 0, 0),
//				LocalDateTime.of(2023, 06, 30, 12, 59));
//		assertEquals(1, qList.size());
//	}

//	@Test
//	void testChange() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
//		for (int i = 0; i < qList.size(); i++) {
//			Question q = qList.get(i);
//			String newStr = q.getSubject().replace("sbb", "kbs");
//			q.setSubject(newStr);
//			this.questionRepository.save(q);
//		}
//	}
//	@Test
//	void testIterable() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
//		Iterator<Question> newthing = qList.iterator();
//		while (newthing.hasNext()) {
//			Question q = newthing.next();
//			String newStr = q.getSubject().replaceAll("sbb", "kbs");
//			q.setSubject(newStr);
//		}
//		this.questionRepository.saveAll(qList);
//	}
//	@Test
//	void testDelete() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("수정된 제목");
//		assertEquals(1, qList.size());
//		System.out.println(qList.get(0));
//		Question q = qList.get(0);
//		this.questionRepository.delete(q);
//		assertEquals(0, qList.size());
//	}
//	@Test
//	void testAnswerSearch() {
//		Optional<Answer> oa = this.answerRepository.findById(3);
//		assertTrue(oa.isPresent());
//	}
//	@Test
//	void testAnswerList() {
//		int[] i = { 3, 4, 5 };
//		List<Answer> oa = this.answerRepository.findByIdIn(i);
//		assertEquals(3, oa.size());
//	}

//	@Test
//	void testAnswerContent() {
//		List<Answer> oa = this.answerRepository.findByContentLike("%답변%");
//		assertEquals(2, oa.size());
//	}
	
	@Test
	void testJpa() {
		for (int i = 1;i <=300;i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			
			String content = "내용무";
			this.questionService.create(subject, content);
		}
	}
}