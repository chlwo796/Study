package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;
// RegisterRequest객체를 검증하기 위한 Validator 구현 클래스
public class RegisterRequestValidator implements Validator {
	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
		System.out.println("RegisterRequestValidator#new(): " + this);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// 파라미터로 전달받은 clazz 객체가 RegisterRequest타입으로 변환 가능한지 확인
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// target = 검사 대상 객체, errors = 검사 결과 에러 코드 설정 객체
		// 검사 대상 객체의 특정 프로퍼티나 상태가 올바른지 검사, 혹은 올바르지 않다면 Errors의 rejectValue()메서드를 이용하여 에러코드 저장
		System.out.println("RegisterRequestValidator#validate(): " + this);
		RegisterRequest regReq = (RegisterRequest) target;
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");	// email 프로퍼티의 에러코드로 required 추가
		} else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");	// 정규표현식이 일치하지 않으면, email 프로퍼티의 에러코드로 bad 추가 
			}
		}
		// ValidationUtils 클래스는 객체의 값 검증 코드를 간결하게 작성할 수 있도록 도와준다.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");	// name 프로퍼티가 null이너가 공백일 경우 에러코드로 required 추가
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if (!regReq.getPassword().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}

}
