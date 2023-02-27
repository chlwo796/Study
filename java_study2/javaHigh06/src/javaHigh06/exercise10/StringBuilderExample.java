package javaHigh06.exercise10;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

//		String str = "";
		for (int i = 1; i <= 100; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
	}
}
