package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {
	// 로그인 요청을 처리하는 클래스
	private AuthService authService;

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping
	public String form(LoginCommand loginCommand) {
		return "login/loginForm";	// 로그인 폼을 보여주기 위해 "login/loginForm" 뷰 사용
	}
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			// todo 세션에 authInfo 저장해야함
			return "login/loginSuccess";	// 로그인 성공시 "loginSuccess" 뷰 사용
		} catch (WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
}
