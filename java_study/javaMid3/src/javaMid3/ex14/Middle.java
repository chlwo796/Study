package javaMid3.ex14;

public class Middle extends School{
// �ߵ���������� �⼮����, �������� �߰�
	
	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest + super.volunteer + super.attendance;
	}
}
