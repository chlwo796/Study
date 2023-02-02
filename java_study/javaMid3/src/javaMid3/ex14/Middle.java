package javaMid3.ex14;

public class Middle extends School {
// 중등과정에서는 출석점수, 봉사점수 추가
	public Middle() {
//		초등학교와는 다르게 출석과 봉사점수를 좀 더 입력받아야한다.
		super("00중학교");
	}

	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest + super.volunteer + super.attendance;
	}

	@Override
	void print(School[] scoreArray) {
		System.out.println("과목명\t담당교사\t중간\t기말\t수행평가\t출석점수\t봉사점수\t총점");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			if (!(scoreArray[i].schoolName).contains("중학교")) {
				continue;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].teacher + "\t" + scoreArray[i].midExam
					+ "\t" + scoreArray[i].finalExam + "\t" + scoreArray[i].performTest + "\t"
					+ scoreArray[i].attendance + "\t" + scoreArray[i].volunteer + "\t" + scoreArray[i].totalScore);
		}

	}

}
