package javaMid3.ex14;

import java.util.Scanner;

public class ScoreManager {
	// 성적을 입력받아서 각각의 자식주소를 참조한 부모클래스를 객체화한다.
	School school; // 최종 부모를 타입으로하는 변수를 선언
	Scanner sc = new Scanner(System.in);
	School[] scoreArray = new School[100];
	String choice;
	int i = 0;

	void input() {
//		선택지에 따라 초등,중등,고등 점수,과목,선생님 배열 생성 -> 데이터는 모두 calculator에서 관리되고 배열은 manager에서 관리된다.
//		1. 초등 -> new Elemantary(); 2. 중등 -> new Middle();
		System.out.println("1. 초등학교 | 2. 중학교 | 3. 고등학교 | 4. 이전단계");
		choice = sc.nextLine();
		switch (choice) {
		case "1":
			school = new Elementary(); // 이게 다형성이다.
			System.out.println("초등학생성적입니다.");
			System.out.println("과목명>");
			school.subject = sc.nextLine();
			System.out.println("중간고사점수>");
			school.midExam = sc.nextInt();
			sc.nextLine();
			System.out.println("기말고사점수>");
			school.finalExam = sc.nextInt();
			sc.nextLine();
			System.out.println("수행평가점수>");
			school.performTest = sc.nextInt();
			sc.nextLine();
			school.cal();
			System.out.println("총 점수 :" + school.totalScore);
			scoreArray[i++] = school;
			break;
		case "2":
			school = new Middle();
			System.out.println("중학생 성적입니다.");
			System.out.println("과목명>");
			school.subject = sc.nextLine();
			System.out.println("중간고사점수>");
			school.midExam = sc.nextInt();
			sc.nextLine();
			System.out.println("기말고사점수>");
			school.finalExam = sc.nextInt();
			sc.nextLine();
			System.out.println("수행평가점수>");
			school.performTest = sc.nextInt();
			sc.nextLine();
			System.out.println("출석점수>");
			school.attendance = sc.nextInt();
			sc.nextLine();
			System.out.println("봉사점수>");
			school.volunteer = sc.nextInt();
			sc.nextLine();

			school.cal();

			System.out.println("총 점수 :" + school.totalScore);
			scoreArray[i++] = school;
			break;
		case "3":
			school = new High();
			System.out.println("중학생 성적입니다.");
			System.out.println("과목명>");
			school.subject = sc.nextLine();
			System.out.println("중간고사점수>");
			school.midExam = sc.nextInt();
			sc.nextLine();
			System.out.println("기말고사점수>");
			school.finalExam = sc.nextInt();
			sc.nextLine();
			System.out.println("수행평가점수>");
			school.performTest = sc.nextInt();
			sc.nextLine();
			System.out.println("출석점수>");
			school.attendance = sc.nextInt();
			sc.nextLine();
			System.out.println("봉사점수>");
			school.volunteer = sc.nextInt();
			sc.nextLine();

			school.cal();
			System.out.println("총 점수 :" + school.totalScore);
			scoreArray[i++] = school;
			break;
		case "4":
			System.out.println("이전단계");
			break;
		default:
		}

	}

	void output() {
//		선택지에 따라 출력. 1. 초등 2. 중등 3. 고등 4. 이전단계
		school = new Elementary();
		System.out.println("초등학생 성적입니다.");
		System.out.println();
	}

	void calculator() {
//		각 주소의 점수를 가져와서 모두 합산, 표준편차 리턴 후 출력 ->Output메소드로넣을까?
	}
}
