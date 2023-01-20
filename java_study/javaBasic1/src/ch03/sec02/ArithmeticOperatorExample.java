package ch03.sec02;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		// 산술 연산자
		// 모든 피연산자가 정수타입이면 연산의 결과는 int 타입이다.
		// 그중 하나가 long이면 연산결과는 long 타입, 실수타입이면 연산결과는 실수타입이다.

		byte value1 = 10;
		byte value2 = 4;
		int value3 = 3;
		long value4 = 100L;

		int result1 = value1 + value2;
		System.out.println(result1);

		long result2 = value1 + value2 + value3 * value4;
		System.out.println(result2);

		double result3 = (double) value1 / value2;
		System.out.println(result3);

		int result4 = value1 % value2;		// value1을 value2 로 나눴을 때의 나머지 값 
		System.out.println(result4);

	}

}
