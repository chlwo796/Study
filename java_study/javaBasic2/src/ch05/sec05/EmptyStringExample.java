package ch05.sec05;

public class EmptyStringExample {

	public static void main(String[] args) {
//		"" 빈문자도 참조할 수 있다.

		String empty = ""; // 빈문자도 String 객체로 생성가능
		if (empty == "") {
			System.out.println("빈문자의 참조 조사 true");
		} else {
			System.out.println("빈문자의 참조 조사 false");
		}
		if (empty.equals("")) {
			System.out.println("문자열조사 = 빈문자");
		} else
			System.out.println("문자열조사 = 빈문자아님");
	}
}
