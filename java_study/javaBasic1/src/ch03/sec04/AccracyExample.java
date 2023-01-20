package ch03.sec04;

public class AccracyExample {

	public static void main(String[] args) {
		// 정확한 계산은 실수연산보다 정수연산으로 하는 것이 좋다.
		
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		
		double result = apple - number*pieceUnit;
		System.out.println("사과 1개에서 남은 양: " + result);		//출력값이 0.3에 근사값으로 나오는 것을 확인할 수 있다.

	}

}
