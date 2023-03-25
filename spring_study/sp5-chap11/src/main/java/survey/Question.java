package survey;

import java.util.List;

public class Question {
	// 개별 설문 항목 데이터를 담기 위한 클래스
	// 설문 항목을 컨트롤러에서 생성해서 뷰에 전달하는 방식으로 변경

	private String title; // 질문 제목
	private List<String> options; // 답변 옵션

	public Question(String title, List<String> options) {

		super();
		this.title = title;
		this.options = options;
	}

	public Question(String title) {
		// 주관식일 경우, 답변 옵션이 없는 Question 객체 생성
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}