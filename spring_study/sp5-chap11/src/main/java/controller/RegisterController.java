package controller;

import java.util.DuplicateFormatFlagsException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

	private MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/register/step2")
	// step2.jsp 에서 스프링이 제공하는 폼태그<form:form> 사용하기 위해 step1에서 step2로 넘어가는 단계에서 "registerRequest"인 객체를 모델에 넣는다.
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		if (!agree) {
			return "register/step1";
		} else {
			model.addAttribute("registerRe quest", new RegisterRequest());
			return "register/step2";
		}
	}

	// 바로 step2로 접근 x, 대신 step1로 접근(오류창없애기)
	// "redirect:" 뒤에 문자열이 "/"로 시작하면 웹 어플리케이션을 기준으로 이동 경로를 생성
	// "/"로 시작하지 않으면 현재 경로를 기준으로 상대경로 사용
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

//	@PostMapping("/register/step3")
//	public String handleStep3(RegisterRequest regReq) {
//		// 회원가입 처리
//		try {
//			memberRegisterService.regist(regReq);
//			return "register/step3";
//		} catch (DuplicateFormatFlagsException e) {
//			return "register/step2";
//		}
//	}
	@PostMapping("/register/step3")	
	// @Valid = 글로벌 범위 Validator가 해당 타입을 검증할 수 있는지 확인, 검증 가능하면 실제 검증을 수행하고, 그 결과를 Errors에 저장
	// Errors 타입 파라미터가 없으면 검증 실패시 400 Error 발생
	public String handleStep3(@Valid RegisterRequest regReq, Errors errors) {
		// 커맨드 객체를 검증하도록 수정
		// Errors 객체는 커맨드 객체의 특정 프로퍼티값을 구할 수 있는 getFieldValue()메소드를 제공하므로
		// ValidationUtils.rejectIfEmptyOrWhitespace() 메소드는 커맨드 객체를 전달받지 않아도 Errors 객체를 이용해서 값을 구할 수 있다.
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			// 에러가 존재하는지 검사
			return "register/step2";
		}
		try {
			memberRegisterService.regist(regReq);	// 동일한 이메일을 가진 회원  데이터가 이미 존재하면 익셉션발생
			return "register/step3";
		} catch (DuplicateMemberException e) {
			errors.rejectValue("emeil", "duplicate"); // email 프로퍼티에 에러추가
			return "register/step2";
		}
		// 커맨드 객체의 특정 프로퍼티가 아닌 커맨드 객체 자체가 잘못된 경우 reject() 메소드 사용
		// 로그인 아이디, 비밀번호의 경우..! 아이디나 비밀번호 특정프로퍼티가 아닌 객체 자체 에러로 처리, 글로벌에러
	}
}