package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView join() {
		return new ModelAndView("board/join");
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String no = this.boardService.create(map);
		if (no == null) {
			mav.setViewName("redirect:/join");
		} else {
			mav.setViewName("redirect:/board?no=" + no);
		}
		return mav;
	}
}