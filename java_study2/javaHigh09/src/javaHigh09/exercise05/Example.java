package javaHigh09.exercise05;

public class Example {
	public static void main(String[] args) {
		Button button1 = new Button();
		button1.setClickListner(() -> {
			System.out.println("OK��ư�� Ŭ���߽��ϴ�.");
		});
		button1.click();

		Button button2 = new Button();
		button2.setClickListner(() -> {
			System.out.println("Cancle��ư�� Ŭ���߽��ϴ�.");
		});
		button2.click();
	}
}
