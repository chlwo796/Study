package javaMid3.ex14.again;

public class HighSchoolStudent extends MiddleSchooler {	// 차이점확인!고등학교는 중학교를 상속받았다.
	private double standardDeviation; // 표준편차

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "고등학생";
		}
	@Override
		void printAll() {
		System.out.println("---------------");
		System.out.println("고등학교 성적입니다.");
		System.out.println("---------------");
		System.out.println("과목명 : " + getSubject());
		System.out.println("담당교사 : " + getTeacher());
		System.out.println(
				"시험 : 중간고사 " + getMidtermExam() + ", 기말고사 : " + getFinals() + ", 수행평가 : " + getPerformanceEvalution() + ", 출석점수 : " + getAttendance() + ", 봉사점수 : " + getServie() + ", 표준편차 : " + getStandardDeviation());
		System.out.println("점수 : " + getScore());
		}
}
