package javaMid11.example01;

public class ExceptionHandlingExample01 {
	public static void printLength(String data) {
		int result = data.length();
		System.out.println("���� �� : " + result);
	}
	public static void main(String[] args) {
//		NullPointerException Example
		System.out.println("���α׷� ����");
		printLength("�ȳ��ϼ���");
		printLength(null);
		System.out.println("���α׷� ����");
	}
}