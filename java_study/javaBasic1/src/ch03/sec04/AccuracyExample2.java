package ch03.sec04;

public class AccuracyExample2 {

	public static void main(String[] args) {
		// 정수연산 Example2
		
		int apple = 1;
		int totalPieces = apple * 10;		// 정수타입으로 통일 후 연산
		int number = 7;
		
		int result = totalPieces - number;
		System.out.println("10조각에서 남은 조각: " + result);
		System.out.println("사과 1개에서 남은양: " + result/10.0);

	}

}
