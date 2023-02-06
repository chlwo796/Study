package javaMid7.ex04;

public class Button {
//	Ŭ���� �ӿ� �������̽�( �������̽� ����?)
	public static interface ClickListener {
//		static �������̽��� �����Ͽ�, �ش� Ŭ������ �����ϴ� ����
		void onClick();
	}

	private ClickListener clickListener;

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}