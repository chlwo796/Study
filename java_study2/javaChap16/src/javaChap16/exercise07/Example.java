package javaChap16.exercise07;

public class Example {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		int max = maxOrMin((result, score) -> {
			if (result >= score) {
				return result;
			} else {
				return score;
			}
		});
		System.out.println(max);

		int min = maxOrMin((result, score) -> {
			if (result <= score) {
				return result;
			} else {
				return score;
			}
		});
		System.out.println(min);
	}
}
