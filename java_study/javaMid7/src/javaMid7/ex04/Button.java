package javaMid7.ex04;

public class Button {
//	클래스 속에 인터페이스( 인터페이스 은닉?)
	public static interface ClickListener {
//		static 인터페이스로 선언하여, 해당 클래스를 독점하는 구조
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