package javaMid3.ex14;

public class Middle extends School{
// 중등과정에서는 출석점수, 봉사점수 추가
	
	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest + super.volunteer + super.attendance;
	}
}
