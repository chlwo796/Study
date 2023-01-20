package ch03.sec11;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		// 삼항(조건)연산자
		// (조건1) ? x : ((조건2)? y : z) 조건 1인가요? true = x, false = 조건2 인가요? true = y, false = z
		int score = 93;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은 " + grade + "등급입니다.");
	}

}
