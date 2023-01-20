package ch03.sec07;

public class LogicalOperatorExample {

	public static void main(String[] args) {
		// 논리연산자

		int charCode = 'A';
		// int charCode = 'a';
		// int charCode = '5'; // char 타입의 변수를 int타입으로 저장. 아스키코드 숫자로 판별 가능.

		if ((65 <= charCode) & (charCode <= 90)) {
			System.out.println("대문자입니다.");
		}
		if ((97 <= charCode) && (charCode <= 122)) {
			System.out.println("소문자입니다.");
		}
		if ((48 <= charCode) && (charCode <= 57)) { // &, && 둘다 가능
			System.out.println("0~9 숫자입니다.");
		}

		// int value = 6;
		int value = 7;

		if ((value % 2 == 0) | (value % 3 == 0)) {
			System.out.println("2 혹은 3의 배수입니다.");
		}

		boolean result = (value % 2 == 0) || (value % 3 == 0); // |, || 둘다 가능
		if (!result) {
			System.out.println("2 혹은 3의 배수가 아닙니다."); // !result = value를 2 혹은 3으로 나누었을때 둘중 한번이라도 나머지가 0이 아니면
		}

	}

}
