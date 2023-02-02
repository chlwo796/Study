package javaMid3.ex14.again;

public class ElemantaryStudent extends SungJuk {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "초등학생";
	}

	@Override
	void printAll() {
		System.out.println("---------------");
		System.out.println("초등학교 성적입니다.");
		System.out.println("---------------");
		System.out.println("과목명 : " + getSubject());
		System.out.println(
				"시험 : 중간고사 " + getMidtermExam() + ", 기말고사 : " + getFinals() + ", 수행평가 : " + getPerformanceEvalution());
		System.out.println("점수 : " + getScore());
	}
}
