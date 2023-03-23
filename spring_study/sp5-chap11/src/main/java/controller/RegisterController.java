package controller;

import java.util.DuplicateFormatFlagsException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			model.addAttribute("registerRequest", new RegisterRequest());
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

	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq) {
		// 회원가입 처리
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateFormatFlagsException e) {
			return "register/step2";
		}
	}
}