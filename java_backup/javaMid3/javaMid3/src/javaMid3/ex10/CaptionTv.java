package javaMid3.ex10;

public class CaptionTv extends TV {
	String text;

	void caption() {
		System.out.println(text);
	}

	@Override
	void channelUp() {
		System.out.println("ÀÚ½Ä°Í");
		channel += 5;
	}
}
