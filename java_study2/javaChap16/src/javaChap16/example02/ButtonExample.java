package javaChap16.example02;

public class ButtonExample {
	public static void main(String[] args) {
		Button btnOk = new Button();

		btnOk.setClickListener(() -> System.out.println("Ok ��ư�� Ŭ���߽��ϴ�."));
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancle ��ư�� Ŭ���߽��ϴ�."));
		btnCancel.click();
	}
}
