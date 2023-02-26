package javaChap12.example05;

public class MathExample {
	public static void main(String[] args) {

		double v1 = Math.ceil(5.3);
		double v2 = Math.floor(5.3);
		System.out.println(v1);
		System.out.println(v2);

		// �ִ밪
		double v3 = Math.max(3, 8);
		double v4 = Math.min(3, 8);
		System.out.println(v3);
		System.out.println(v4);
		
		double v5 = 12.7849;
		double temp1 = v5 *100;
		double temp2 = Math.round(temp1);
		double result = temp2/100.0;
		System.out.println(result);
	}
}
