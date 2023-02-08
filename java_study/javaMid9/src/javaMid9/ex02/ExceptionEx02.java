package javaMid9.ex02;

public class ExceptionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			문법적인 오류는 없다. 컴파일러가 오류를 찾을 수 없다.
			int[] number = { 1, 5, 6, 43, 2 };
			System.out.println(number[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("정상종료");
		}
	}
}
