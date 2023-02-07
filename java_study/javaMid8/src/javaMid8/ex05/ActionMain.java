package javaMid8.ex05;

public class ActionMain {
	public static void main(String[] args) {
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("interface Action의 익명구현객체");
				System.out.println("복사를 합니다.");

			}
		};
		action.work();
	}
}
