package javaMid3.ex14;

public class Elementary extends School {
//	�ʵ��л� ������
	
	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest;
	}
}
