package javaHigh06.exercise08;

public class MeasureTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int[] scores = new int[1000];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = i;
		}

		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		double average = sum / scores.length;
		System.out.println(average);
		long endTime = System.nanoTime();
		System.out.println("진행시간 : " + (endTime-startTime) + "나노초");
	}
}