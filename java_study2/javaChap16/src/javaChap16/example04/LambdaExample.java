package javaChap16.example04;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		person.action((x, y) -> {
			double result = x + y;
			return result;
		});
		// return문 생략 후 연산식으로 대체
		person.action((x, y) -> (x + y));
		// return 생략 후 메소드로 대체
		person.action((x, y) -> sum(x, y));
	}

	public static double sum(double x, double y) {
		return x + y;
	}
}