package ch04.sec03;

public class SwitchCharExample {

	public static void main(String[] args) {
//		switch-case variable 예제
//		switch-case의 변수는 정수타입(byte, short, char, int, long) 문자열타입(String) 변수를 사용할 수 있다.
		
		char grade = 'A';

		switch (grade) {
		case 'a':
		case 'A':
			System.out.println("우수회원입니다");
			break;
		case 'b':	// 대소문자 상관없이 하는 경우 실행문을 하나로만 하면 가능
		case 'B':
			System.out.println("일반회원입니다");
			break;
		default:
			System.out.println("아무것도아닙니다");
		}
//		char변수를 활용하여 결과물 출력하기(대소문자 상관없이)
	}

}
