package survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey") // form(), submit() 이 처리하는 경로 = "/survey"
public class SurveyController {
	// 설문 항목을 뷰에 전달하도록 수정
	@GetMapping
	public String form(Model model) {
		// Model 타입의 파라미터 추가
		List<Question> questions = createQuestions();
		// "questions"라는 이름으로 모델에 추가
		model.addAttribute("questions",questions);
		return "survey/surveyForm"; // 뷰 이름으로 survey/surveyForm 설정
	}
	private List<Question> createQuestions(){
		Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("서버", "프론트", "풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("이클립스", "인텔리J", "서브라임"));
		Question q3 = new Question("하고싶은 말을 적어주세요.");
		return Arrays.asList(q1,q2,q3);
	}
	
//	@GetMapping
//	public ModelAndView form() {
//		// ModelAndView를 사용하여 모델과 뷰 이름을 함께 제공, 한번에 처리 가능
//		List<Question> questions = createQuestions();
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("questions", questions);	// 뷰에 전달할 모델 데이터 추가
//		mav.setViewName("survey/surveyForm");	// 뷰 이름 설정
//		return mav;
//	}
	
//	@GetMapping
//	public String form() {
//		return "survey/surveyForm"; // 뷰 이름으로 survey/surveyForm 설정
//	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted"; // 뷰 이름으로 survey/submitted 설정
	}
}