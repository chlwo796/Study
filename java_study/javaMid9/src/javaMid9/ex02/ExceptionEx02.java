package javaMid9.ex02;

public class ExceptionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			�������� ������ ����. �����Ϸ��� ������ ã�� �� ����.
			int[] number = { 1, 5, 6, 43, 2 };
			System.out.println(number[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("��������");
		}
	}
}
