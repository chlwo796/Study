package ch04.sec03;

public class SwitchNoBreakCaseExample {

	public static void main(String[] args) {
//		Break 없이 switch-case 프로그램 예제
//		8~11 number random
		int a = (int) ((Math.random() * 3) + 8);
		System.out.println("현재시간은" + a + "시 입니다.");

		switch (a) {
		case 8:
			System.out.println("외근을 합니다.");
		case 9:
			System.out.println("야근을 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		default:
			System.out.println("퇴근을 합니다.");
		}
//		각 case에서 break;가 없으면 a값과는 상관없이 case, default가 모두 실행된다.
//		처음에 9가 나왔다면 8 실행 x -> 9, 10, default 모두 실행 -> 그래서 break;가 필요하다.

	}

}
