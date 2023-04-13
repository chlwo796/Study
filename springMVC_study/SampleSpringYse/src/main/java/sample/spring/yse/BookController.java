package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		String bookId = this.bookService.create(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		// 책상세화면
		Map<String, Object> detailMap = this.bookService.detail(map);
		ModelAndView mav = new ModelAndView();
		if (detailMap == null) {
			mav.setViewName("/book/error");
		} else {
			mav.addObject("data", detailMap); // 뷰로 detailMap의 값(데이터베이스에서 받은 ResultSet)을 data 속성에 담아서 보내라
			String bookId = map.get("bookId").toString();
			mav.addObject("bookId", bookId);
			// http://localhost:8085/yse/detail?bookId=5&bookQr=50&bookPublisher=한빛
//	    String bookQr = map.get("bookQr").toString();
//	    mav.addObject( "bookQrName" , bookQr );//  bookQr값을 받아서 뷰의 bookQrAName 속성값으로 보내라
//	    String bookPub=map.get("bookPublisher").toString();
//	    mav.addObject("bookPubName", bookPub);
//	    String a = map.get("a").toString();
//	    String b = map.get("b").toString();
//	    mav.addObject("a", a);
//	    mav.addObject("b", b);
			mav.setViewName("/book/detail"); // src/main/webapp/web-inf/views/book/detail.jsp파일로 응답해라
		}
		return mav;
	}

	// 수정기능 컨트롤러 추가
	// 요청 -> 처리 = 서비스 객체 전달 -> 뷰객체 생성 -> 응답
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> detailMap = this.bookService.detail(map);
		mav.addObject("data", detailMap);
		mav.setViewName("/book/update"); // update.jsp로 응답
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		boolean isUpdateSuccess = this.bookService.edit(map);
		if (isUpdateSuccess) {
			// 정상실행 후 상세페이지화면으로 이동
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		} else {
			// 정상실행이 아니면, 상세페이지 화면 이동
			mav = this.update(map);
		}
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		boolean isDeleteSuccess = this.bookService.remove(map);
		if (isDeleteSuccess) {
			// 삭제 후 list.jsp 화면이동
			mav.setViewName("redirect:/list");
		} else {
			String bookId = map.get("bookId").toString();
			// 실패 후 상세페이지 이동
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		// 책 목록 db에서 가지고옴
		List<Map<String, Object>> list = this.bookService.list(map);
		// 데이터뷰에 전달
		mav.addObject("data", list);
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		// /book/list 뷰 리턴, list.jsp
		mav.setViewName("/book/list");
		return mav;
	}
}