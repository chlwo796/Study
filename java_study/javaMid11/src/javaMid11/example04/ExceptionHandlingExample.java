package javaMid11.example04;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		String[] array = { "100", "1oo" };

		for (int i = 0; i <= array.length; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "] : " + value);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭 �ε����� �ʰ���:" + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("���࿡ ������ �ֽ��ϴ�.");
			}
		}
	}
}
