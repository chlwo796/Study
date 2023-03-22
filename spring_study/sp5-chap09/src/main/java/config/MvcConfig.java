package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // 스프링 MVC 설정 활성화
public class MvcConfig implements WebMvcConfigurer {
	// WebMvcConfigurer 인터페이스 = 스프링 MVC의 개별 설정을 조정할 때 사용
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// DispatcherServlet의 매핑 경로를 '/'로 주었을 때, JSP/HTML/CSS 등을 올바르게 처리하기 위한 설정 추가
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// JSP를 이용해서 컨트롤러의 실행 결과를 보여주기 위한 설정 추가
		// jsp() 의 첫번째 인자는 JSP 파일 경로를 찾을 때 사용할 접두어, 두번째 인자는 접미사
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
}