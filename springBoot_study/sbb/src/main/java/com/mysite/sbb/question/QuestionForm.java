package com.mysite.sbb.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class QuestionForm {

	@NotEmpty(message = "제목은 필수항목입니다.")
	@Size(max = 200) // 최대 길이 = 200바이트
	private String subject;

	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;

}