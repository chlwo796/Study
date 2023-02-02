package javaMid3.ex14;

import java.util.Scanner;

public class School { // 고등학교데이터까지 전부 관리한다. // 입력시 부모타입으로 전부 형성한다.
//	ScoreManager class 에서 데이터를 받아 각 자식클래스로 메소드를 오버라이딩한다.
//	표준편차는 그냥 값을 대입하는 것으로 한다.
	Scanner sc;
	String schoolName; // 다형성할때마다 school이라는 변수에 각 초등학교,중학교,고등학교를 받아서 생성자로 출력한다. ScoreManager를 간결하게하려고
	String subject; // 과목마다 점수가 새로 생긴다.
	String teacher; // 선생님마다 점수가 새로 생긴다. -> subject와 teacher는 한묶음
	String test; // 중간 or 기말
	int totalScore; // 모두 합산
	int midExam; // 중간고사
	int finalExam; // 기말고사
	int performTest; // 수행평가
	int attendance; // 출석점수
	int volunteer; // 봉사점수
	double sd; // 표준편차

//	public School[] getSchoolArray() {
//		return schoolArray;
//	}
//
//	public void setSchoolArray(School[] schoolArray) {
//		this.schoolArray = schoolArray;
//	}

	public School(String schoolName) {
//		부모의 기본생성자.
		this.schoolName = schoolName;
		System.out.println("--------------");
		System.out.println(schoolName + " 성적입니다.");
		System.out.println("--------------");
	}

	void cal() {
		System.out.println("부모의 계산기입니다. 데이터가 없습니다.");
	}

	void print(School[] scoreArray) {
		System.out.println("부모 메소드입니다. 출력할 내용이 없습니다.");

	}

	final void printAll(School[] scoreArray) {
		System.out.println("과목명\t담당교사\t중간\t기말\t수행평가\t출석점수\t봉사점수\t표준편차\t총점");
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == null) {
				return;
			}
			System.out.println(scoreArray[i].subject + "\t" + scoreArray[i].teacher + "\t" + scoreArray[i].midExam
					+ "\t" + scoreArray[i].finalExam + "\t" + scoreArray[i].performTest + "\t"
					+ scoreArray[i].attendance + "\t" + scoreArray[i].volunteer + "\t" + scoreArray[i].sd + "\t"
					+ scoreArray[i].totalScore);

		}
	}
}
