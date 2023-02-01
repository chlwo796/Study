package javaMid3.ex14;

public class Elementary extends School {
//	초등학생 데이터
	public Elementary() {
		super("00초등학교");
	}

	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest;
	}

	@Override
	void print(School[] scoreArray) {
		System.out.println("과목명\t중간\t기말\t수행평가\t점수");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			if (!(scoreArray[i].schoolName).contains("초등학교")) {
				continue;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].midExam + "\t" + scoreArray[i].finalExam
					+ "\t" + scoreArray[i].performTest + "\t" + scoreArray[i].totalScore);
		}
	}
}