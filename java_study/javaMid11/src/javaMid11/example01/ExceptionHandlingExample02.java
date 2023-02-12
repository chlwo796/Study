package javaMid11.example01;

public class ExceptionHandlingExample02 {
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("문자 수 : " + result);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			System.out.println("마무리 실행");
		}
	}

	public static void main(String[] args) {
//		NullPointerException Example
		System.out.println("프로그램 시작");
		printLength("안녕하세요");
		printLength(null);
		System.out.println("프로그램 종료");
	}
}