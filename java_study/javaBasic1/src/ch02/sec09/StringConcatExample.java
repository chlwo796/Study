package ch02.sec09;

public class StringConcatExample {

	public static void main(String[] args) {
		// 문자접합 예제
		int v1 = 10 + 11 + 23;
		System.out.println(v1);

		String v2 = 10 + 20 + "1";
		System.out.println(v2);

		String v3 = 10 + "30" + "22";
		System.out.println(v3);

		String v4 = "10" + 30 + 22;		//문자열연산이 먼저 진행되면 뒤에 연산도 문자열연산
		System.out.println(v4);

		String v5 = "10" + (30 + 22);	//괄호안에 숫자 연산진행
		System.out.println(v5);

	}

}
