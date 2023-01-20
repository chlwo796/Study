package ch04.sec02;

public class IfNestedExample {

	public static void main(String[] args) {
		// 간단한 채점 프로그램
		// 81<=, <=100 랜덤숫자 0<=, <=19
		int score = (int) ((Math.random() * 19 + 81));

		String grade = null;	// method 전체에서 쓰일 초기값(0) 설정. 그래야 if 밖에 나가서도 변경된 값을 유지하며 실행된다.

		if (score >= 90) {
			if (score >= 95) {
				grade = "A+";
			} else {
				grade = "A";
			}
		}
		if (score >= 80) {
			if (score >= 85) {
				grade = "B+";
			} else {
				grade = "B";
			}
		}
		System.out.println("점수 : " + score + ", 학점 : " + grade);
	}

}
