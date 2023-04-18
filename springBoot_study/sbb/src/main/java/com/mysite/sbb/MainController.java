package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// 스프링부트의 컨트롤러
public class MainController {
	// 서버에 요청이 발생하면 스프링부트는 요청 페이지와 매핑되는 메소드를 컨트롤러를 대상으로 찾는다.
	// http://localhost:9000/sbb 요청이 발생하면
	// /sbb url과 매핑되는 index메소드를 MainController 클래스에서 찾아서 실행한다.
	@GetMapping("/sbb")	// 요청된 url과의 매핑 담당
	@ResponseBody
	public String index() {
		return "sbb에 오신것을 환영합니다.";
	}
} 