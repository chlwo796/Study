package tempMemo;

public class Main {
	public static void main(String[] args) {
//		A a = new A(); 		// private 생성자로 인해 객체생성 불가.
		A.getInstance(); // 메소드로 접근한다.
							// static method 로 자신을 객체생성 했을 때에 메모리에 바로 올라간다.
	}
}
