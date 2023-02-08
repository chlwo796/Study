package javaMid9.ex01;

public class ExceptionEx01 {

	public static void main(String[] args) {
//		예외처리
		try {
		System.out.println(10/0);
		}catch(ArithmeticException a) {
//			예외가 발생하면 처리할 코드 작성
			System.out.println(a.getMessage());
			System.out.println("예외발생");
		}finally {
//			예외와 상관없이 무조건 처리되는 코드작성
			System.out.println("데이터베이스 닫기/종료하기");
		}
	}

}
