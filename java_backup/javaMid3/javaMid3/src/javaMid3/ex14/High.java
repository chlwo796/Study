package javaMid3.ex14;

public class High extends School {
//	고등에서는 표준편차추가
	public High() {
//	고등학생 기본생성자, 출석,봉사점수 추가로 입력받아볼까?
		super("00고등학교");

	}

	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.totalScore = super.midExam + super.finalExam + super.performTest + super.volunteer + super.attendance;
		super.sd = 23.12;
	}

	@Override
	void print(School[] scoreArray) {
		System.out.println("과목명\t담당교사\t중간\t기말\t수행평가\t출석점수\t봉사점수\t표준편차\t총점");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			if (!(scoreArray[i].schoolName).contains("고등학교")) {
				continue;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].teacher + "\t" + scoreArray[i].midExam
					+ "\t" + scoreArray[i].finalExam + "\t" + scoreArray[i].performTest + "\t"
					+ scoreArray[i].attendance + "\t" + scoreArray[i].volunteer + "\t" + scoreArray[i].sd + "\t"
					+ scoreArray[i].totalScore);
		}
	}
}
