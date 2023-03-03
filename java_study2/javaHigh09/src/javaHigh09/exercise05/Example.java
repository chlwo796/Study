package javaHigh09.exercise05;

public class Example {
	public static void main(String[] args) {
		Button button1 = new Button();
		button1.setClickListner(() -> {
			System.out.println("OK버튼을 클릭했습니다.");
		});
		button1.click();

		Button button2 = new Button();
		button2.setClickListner(() -> {
			System.out.println("Cancle버튼을 클릭했습니다.");
		});
		button2.click();
	}
}
