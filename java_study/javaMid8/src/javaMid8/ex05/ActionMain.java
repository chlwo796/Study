package javaMid8.ex05;

public class ActionMain {
	public static void main(String[] args) {
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("interface Action�� �͸�����ü");
				System.out.println("���縦 �մϴ�.");

			}
		};
		action.work();
	}
}
