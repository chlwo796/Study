package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	// 스프링 MVC에서 컨트롤러로 사용할 클래스 지정
// 스프링 MVC프레임워크에서 컨트롤러는 웹 요청을 처리하고 그 결과를 뷰에 전달하는 스프링 빈 객체이다.
public class HelloController {
	@GetMapping("/hello")	// 메소드가 처리할 요청 경로를 지정("/hello)
	public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
		// Model 파라미터는 컨트롤러의 처리 결과를 뷰에 전달할 때 사용한다.
		// @RequestParam() = HTTP 요청 파라미터의 값을 메소드의 파라미터로 전달할 때 사용 "name"->String name
		model.addAttribute("greeting", "안녕하세요, " + name);	// "greeting"이라는 값을 모델 속성에 값을 설정
		// addAttribute() = 첫번째 파라미터는 데이터를 식별하는데 사용되는 속성이름이고, 두번째 파라미터는 속성 이름에 해당하는 값이다.
		return "hello";	// 컨트롤러의 처리 결과를 보여줄 뷰 이름으로 "hello"를 사용한다.
	}
}
