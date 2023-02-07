package javaMid8.ex06;

// 확인문제 9.6

public class AnonymousMain {
	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		anonymous.field.run();
		anonymous.method1();
		anonymous.method2(new Vehicle() {
//			메소드에서 바로 익명구현객체를 만들어서 호출하기. 매우중요.
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}