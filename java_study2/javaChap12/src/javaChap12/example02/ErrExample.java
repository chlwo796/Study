package javaChap12.example02;

public class ErrExample {
	public static void main(String[] args) {
		try {
			int value = Integer.parseInt("1oo");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.err.println("에러내용");
			System.err.println(e.getMessage());
		}
	}
}
