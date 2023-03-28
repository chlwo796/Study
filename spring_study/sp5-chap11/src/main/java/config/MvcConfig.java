package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import controller.RegisterRequestValidator;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// step3.jsp 의 회원가입 완료 후 첫화면 이동 로직
		// 요청 경로와 뷰 이름을 연결
		registry.addViewController("/main").setViewName("main");
	}

	@Bean
	public MessageSource messageSource() {
		// 스프링은 로케일에 상관없이 일관된 방법으로 문자열을 관리할 수 있는 MessageSource 인터페이스를 정의하고있다.
		// 특정 로케일에 해당하는 메시지가 필요한 코드는 getMessage() 메소드를 이용하여 필요한 메시지를 가져와서 사용하는 방식
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label"); // message 패키지에 속한 label 프로퍼티 파일로부터 메시지를 읽어오도록 설정
		// setBasenames() 메소드는 가변 인자이므로, 사용할 메시지 프로퍼티 목록을 전달할 수 있다.
		ms.setDefaultEncoding("UTF-8"); // label.properties 파일이 UTF-8 인코딩이므로 디폴트설정 = UTF-8
		return ms;
	}
	// bean validation 어노테이션설정 후 해당 글로벌 범위 Validator 설정삭제
	@Override
	public Validator getValidator() {
		// 글로벌 범위 Validator 적용
		// 스프링 MVC는 WebMvcConfigurer 인터페이스의 getValidator() 메소드가 리턴한 객체를 글로벌 범위 Validator로 사용
		return new RegisterRequestValidator();
	}
}