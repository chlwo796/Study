package javaMid11.example01;

public class ExceptionHandlingExample02 {
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("���� �� : " + result);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			System.out.println("������ ����");
		}
	}

	public static void main(String[] args) {
//		NullPointerException Example
		System.out.println("���α׷� ����");
		printLength("�ȳ��ϼ���");
		printLength(null);
		System.out.println("���α׷� ����");
	}
}