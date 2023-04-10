package sample.spring.yes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // 아래있는 클래스 BookController의 역할은 컨트롤러 역할
public class BookController {
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	// test1이라는 요청이 들어오면 test1.jsp 가 실행되도록
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public ModelAndView test1() {
		return new ModelAndView("test/test1");
	}

	@RequestMapping(value = "/testlogin", method = RequestMethod.GET)
	public ModelAndView testLogin() {
		return new ModelAndView("test/testlogin");
	}

	@RequestMapping(value = "testjoin", method = RequestMethod.GET)
	public ModelAndView testJoin() {
		return new ModelAndView("test/testjoin");
	}
	@RequestMapping(value = "testboard", method = RequestMethod.GET)
	public ModelAndView testBoard(){
		return new ModelAndView("test/testboard");
	}
}
