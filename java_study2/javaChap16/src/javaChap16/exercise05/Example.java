package javaChap16.exercise05;

public class Example {
	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setClickListener(() -> System.out.println("OK ��ư�� Ŭ���߽��ϴ�."));
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancel ��ư�� Ŭ���߽��ϴ�."));
		btnCancel.click();
	}
}
