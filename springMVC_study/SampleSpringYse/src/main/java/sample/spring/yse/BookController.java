package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	static {
		System.out.println("요기에 왓나요?");
	}

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		System.out.println("중간");
		return new ModelAndView("book/create");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		System.out.println("중간1");
		ModelAndView mav = new ModelAndView();

		String bookId = this.bookService.create(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
}