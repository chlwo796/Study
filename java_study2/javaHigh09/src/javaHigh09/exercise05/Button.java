package javaHigh09.exercise05;

public class Button {

	@FunctionalInterface
	public static interface ClickListener{
		void onClick();
	}
	private ClickListener clickListner;
	
	public ClickListener getClickListner() {
		return clickListner;
	}

	public void setClickListner(ClickListener clickListner) {
		this.clickListner = clickListner;
	}

	public void click() {
		this.clickListner.onClick();
	}
}
