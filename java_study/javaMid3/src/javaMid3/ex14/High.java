package javaMid3.ex14;

public class High extends School{
//	고등에서는 표준편차추가

@Override
void cal() {
	// TODO Auto-generated method stub
	super.totalScore = super.midExam + super.finalExam + super.performTest + super.volunteer + super.attendance;
	super.sd = 23.12;
}
}


