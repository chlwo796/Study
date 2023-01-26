package ch06.day02;

public class ClassEx04 {

	public static void main(String[] args) {

		Computer c1 = new Computer();
		System.out.println(c1.sum(1, 2));
		System.out.println(c1.sum(1, 2, 3, 4));
		System.out.println(c1.sum(1, 2, 3));

		System.out.println(c1.cc("a", "b"));
		System.out.println(c1.cc("a", "b", "c"));
		System.out.println(c1.cc("a", "b", "c", "d"));
		

		int[] array = null;
		System.out.println(array.length);
	}
}

class Computer {
	String total;

//	... = 가변길이 매개변수, 나머지, 여러 값
	int sum(int... values) {
		int total = 0;
		for (int i = 0; i < values.length; i++) {
			total += values[i];
		}
		return total;
	}

	String cc(String... values) {

		for (int i = 0; i < values.length; i++) {
			total += values[i];
		}
		return total;
	}
//	method name은 동일하나 매개변수가 다른 것 : method 재사용(Overloading)
//	int sum(int a, int b) {
//		return a + b;
//	}
//
//	int sum(int a, int b, int c, int d) {
//		return a + b + c + d;
//	}
//
//	int sum(int a, int b, int c) {
//		return a + b + c;
//	}

}