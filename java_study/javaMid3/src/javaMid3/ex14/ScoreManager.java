package javaMid3.ex14;

import java.util.Scanner;

public class ScoreManager {
	// 성적을 입력받아서 각각의 자식주소를 참조한 부모클래스를 객체화한다.
	School school; // 최종 부모를 타입으로하는 변수를 선언
	Scanner sc = new Scanner(System.in);
	School[] scoreArray = new School[100]; // 배열을 만든다는것은 여러번 입력받아서 배열의 나열로 데이터를 관리하겠다는 개념.
	String choice;
	boolean run;
	int i = 0;

	void input() {
//		선택지에 따라 초등,중등,고등 점수,과목,선생님 배열 생성 -> 데이터는 모두 calculator에서 관리되고 배열은 manager에서 관리된다.
//		1. 초등 -> new Elemantary(); 2. 중등 -> new Middle();
		run = true;
		while (run) {
			System.out.println("1. 초등학교 | 2. 중학교 | 3. 고등학교 | 4. 이전단계");
			System.out.print("선택>");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				school = new Elementary();
				System.out.print("과목명 : ");
				school.subject = sc.nextLine();
				System.out.print("중간고사점수: ");
				school.midExam = sc.nextInt();
				System.out.print("기말고사점수: ");
				school.finalExam = sc.nextInt();
				System.out.print("수행평가점수: ");
				school.performTest = sc.nextInt();
				sc.nextLine();
				school.cal();
				System.out.println("점수 : " + school.totalScore);
				scoreArray[i++] = school;

				break;
			case "2":
				school = new Middle();
				System.out.print("과목명 : ");
				school.subject = sc.nextLine();
				System.out.print("담당교사 : ");
				school.teacher = sc.nextLine();
				System.out.print("중간고사점수 : ");
				school.midExam = sc.nextInt();
				System.out.print("기말고사점수 : ");
				school.finalExam = sc.nextInt();
				System.out.print("수행평가점수 : ");
				school.performTest = sc.nextInt();
				System.out.print("출석점수 : ");
				school.attendance = sc.nextInt();
				System.out.print("봉사점수 : ");
				school.volunteer = sc.nextInt();
				sc.nextLine();
				school.cal();
				System.out.println("총 점수 :" + school.totalScore);
				scoreArray[i++] = school;
				break;
			case "3":
				school = new High();
				System.out.println("과목명 : ");
				school.subject = sc.nextLine();
				System.out.println("담당교사 : ");
				school.teacher = sc.nextLine();
				System.out.print("중간고사점수 : ");
				school.midExam = sc.nextInt();
				System.out.print("기말고사점수 : ");
				school.finalExam = sc.nextInt();
				System.out.print("수행평가점수 : ");
				school.performTest = sc.nextInt();
				System.out.print("출석점수 : ");
				school.attendance = sc.nextInt();
				System.out.print("봉사점수 : ");
				school.volunteer = sc.nextInt();
				sc.nextLine();
				school.cal();
				System.out.println("총 점수 :" + school.totalScore);
				scoreArray[i++] = school;
				break;
			case "4":
				run = false;
				System.out.println("이전단계");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	void output() {
//		선택지에 따라 출력. 1. 초등 2. 중등 3. 고등 4. 이전단계
		run = true;
		while (run) {
//			여기서 초기화 해줘야할거같다..어떻게하지..다형성초기화는?
			// 이거 되는건가
			System.out.println("1. 초등학교 | 2. 중학교 | 3. 고등학교 | 4. 전체 | 5. 이전단계");
			System.out.println("선택>");
			choice = sc.nextLine();
			switch (choice) {
			case "1": {
				school = new Elementary(); // 여기서 배열값이 관리되있다. 메소드에서 배열값에 대한 조건을 어떻게 할까..
				school.print(scoreArray); // 여기서 scoreArray[0]만 넣어야한다. - 초등학교배열, 또 무슨조건이 있을까..
				break;
			}
			case "2": {
				school = new Middle();
				school.print(scoreArray);
				break;
			}
			case "3": {
				school = new High();
				school.print(scoreArray);
				break;
			}
			case "4": {
				school = new School();
				school.print(scoreArray);
				break;
			}
			case "5": {
				run = false;
				break;
			}
			default: {
				System.out.println("잘못입력하셨습니다.");
			}
			}
		}
	}
}
