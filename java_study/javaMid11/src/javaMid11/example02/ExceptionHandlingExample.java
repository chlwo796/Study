package javaMid11.example02;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		try {
			Class.forName("java.lang.String");
			System.out.println("java.lang.String Ŭ������ �����մϴ�.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String2 Ŭ������ �����մϴ�.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
