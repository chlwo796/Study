package javaMid11.example01;

public class ExceptionHandlingExample01 {
	public static void printLength(String data) {
		int result = data.length();
		System.out.println("문자 수 : " + result);
	}
	public static void main(String[] args) {
//		NullPointerException Example
		System.out.println("프로그램 시작");
		printLength("안녕하세요");
		printLength(null);
		System.out.println("프로그램 종료");
	}
}