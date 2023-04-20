package com.mysite.sbb.answer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer") // AnswerController URL 프리픽스 /answer로 고정
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService questionService;
	private final AnswerService answerService;

	@PostMapping("/create/{id}") // post 방식으로 매핑
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
			BindingResult bindingResult) {
		// 내용검증 내용 추가
		Question question = this.questionService.getQuestion(id);

		if (bindingResult.hasErrors()) {
			// 내용이 없는 경우 다시 답변을 등록할 수 있도록 question_detail 랜더링
			// 랜더링 시 Question 객체가 필요하므로 model 객체에 Question 객체를 저장 후 랜더링
			model.addAttribute("question", question);
			return "question_detail";
		}
		this.answerService.create(question, answerForm.getContent()); // 답변 저장
		return String.format("redirect:/question/detail/%s", id);
	}
}