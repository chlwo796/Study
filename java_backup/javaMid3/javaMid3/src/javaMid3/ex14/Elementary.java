package javaMid3.ex14;

public class Elementary extends School {
//	초등학생 데이터
	
	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest;
	}
}
