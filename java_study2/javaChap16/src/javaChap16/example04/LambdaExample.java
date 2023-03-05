package javaChap16.example04;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		person.action((x, y) -> {
			double result = x + y;
			return result;
		});
		// return�� ���� �� ��������� ��ü
		person.action((x, y) -> (x + y));
		// return ���� �� �޼ҵ�� ��ü
		person.action((x, y) -> sum(x, y));
	}

	public static double sum(double x, double y) {
		return x + y;
	}
}