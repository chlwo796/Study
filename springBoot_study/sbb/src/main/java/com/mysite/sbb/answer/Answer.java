package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // jpa가 엔티티로 인식
public class Answer {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스설정(자동번호증가)
	private Integer id;
	@Column(length = 200)
	private String subject;
	@Column(columnDefinition = "TEXT") // 글자 수 제한할 수 없는 경우
	private String content;
	@CreatedDate
	private LocalDateTime createDate;
	@ManyToOne
	private Question question;

	@ManyToOne
	private SiteUser author;

	private LocalDateTime modifyDate;

	@ManyToMany
	Set<SiteUser> voter;
}
