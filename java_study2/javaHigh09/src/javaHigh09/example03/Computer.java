package javaHigh09.example03;

public class Computer {
	public static double staticMethod(double x, double y) {
		return x + y;
	}

	public double instanceMethod(double x, double y) {
		return x + y;
	}

	public static void voidMethod(double x, double y) {
		System.out.println("void¸Þ¼Òµå");
		System.out.println(x);
		System.out.println(y);
	}
}