package javaMid9.ex01;

public class ExceptionEx01 {

	public static void main(String[] args) {
//		����ó��
		try {
		System.out.println(10/0);
		}catch(ArithmeticException a) {
//			���ܰ� �߻��ϸ� ó���� �ڵ� �ۼ�
			System.out.println(a.getMessage());
			System.out.println("���ܹ߻�");
		}finally {
//			���ܿ� ������� ������ ó���Ǵ� �ڵ��ۼ�
			System.out.println("�����ͺ��̽� �ݱ�/�����ϱ�");
		}
	}

}
