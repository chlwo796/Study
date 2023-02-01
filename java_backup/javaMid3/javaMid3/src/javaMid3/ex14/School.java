package javaMid3.ex14;

public class School {	//고등학교데이터까지 전부 관리한다.	// 입력시 부모타입으로 전부 형성한다.
//	ScoreManager class 에서 데이터를 받아 각 자식클래스로 메소드를 오버라이딩한다.
//	표준편차는 그냥 값을 대입하는 것으로 한다.
	
	String subject;	// 과목마다 점수가 새로 생긴다.
	String teacher; // 선생님마다 점수가 새로 생긴다. -> subject와 teacher는 한묶음
	String test;	// 중간 or 기말
	int totalScore;	// 모두 합산
	int midExam;	// 중간고사
	int finalExam;	// 기말고사
	int performTest;	// 수행평가
	int attendance;	// 출석점수
	int volunteer;	//봉사점수
	double sd; // 표준편차
	
	void cal() {
		System.out.println("부모의 계산기입니다. 데이터가 없습니다.");
	}
}