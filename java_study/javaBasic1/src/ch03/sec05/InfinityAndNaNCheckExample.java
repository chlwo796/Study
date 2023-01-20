package ch03.sec05;

public class InfinityAndNaNCheckExample {

	public static void main(String[] args) {
		// Infinity(무한대), NaN(Not a Number)
		// 나눗셈 혹은 %연산에서 좌측피연산자가 정수이고 우측 피연산자가 0일 경우 ArithmeticException 발생.
		int x = 5;
		double y = 0.0;
		double z = x / y; // 좌측 피연산자가 실수형, 혹은 우측 피연산자가 0.0, 0.0f이면 예외가 아닌 Infinity, NaN 출력.
		// double z = x%y; // 잘못된 코드
		System.out.println(z + 2);

		if (Double.isInfinite(z) || Double.isNaN(z)) {
			System.out.println("값 산출 불가");
		} else {
			System.out.println(z + 2);
		}

	}

}
