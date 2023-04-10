package sample.spring.yes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // �Ʒ��ִ� Ŭ���� BookController�� ������ ��Ʈ�ѷ� ����
public class BookController {
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	// test1�̶�� ��û�� ������ test1.jsp �� ����ǵ���
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
