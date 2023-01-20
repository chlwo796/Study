package ch03.sec06;

public class CompareOperatorExample {

	public static void main(String[] args) {
		// 비교연산자
		int num1 = 10;
		int num2 = 10;
		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);

		char char1 = 'a';
		char char2 = 'b';
		boolean result4 = char1 < char2; // 아스키코드 참조
		System.out.println("result4 : " + result4);

		int num3 = 1;
		double num4 = 1.0;
		boolean result5 = (num3 == num4);
		System.out.println("result5 : " + result5);

		float num5 = 0.1f;
		double num6 = 0.1;
		boolean result6 = (num5 == num6);
		boolean result7 = (num5 == (float) num6); // 예외. float 타입과 double 타입의 정밀도 차이때문에 오류가 발생한다.
		System.out.println("result6 : " + result6); // 부동 소수점 방식을 사용하는 실수타입은 0.1을 정확히 표현 할 수 없다.
		System.out.println("result7 : " + result7); // 강제형변환 시 true가 성립한다.

		String str1 = "자바";
		String str2 = "Java";
		boolean result8 = str1.equals(str2);
		boolean result9 = !str1.equals(str2);
		System.out.println("result8 : " + result8);
		System.out.println("result9 : " + result9);
	}

}
