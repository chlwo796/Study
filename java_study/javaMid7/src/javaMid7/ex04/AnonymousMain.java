package javaMid7.ex04;

public class AnonymousMain {

	public static void main(String[] args) {
//		이 구조는 화면을 구현할 때 사용하는 구조이다.
		Button button1 = new Button();

		class OKListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("OK버튼을 클릭했습니다.");
			}
		}
		button1.setClickListener(new OKListener());

		button1.click();

		Button button2 = new Button();
		class CancleListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("cancle버튼 클릭");

			}
		}
		button2.setClickListener(new CancleListener());

		button2.click();

		Button button3 = new Button();
		class SpaceBarListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("SpaceBar버튼 클릭");
			}
		}
		button3.setClickListener(new SpaceBarListener());

		button3.click();

		Button button4 = new Button();

		class MouthListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Mouth버튼 클릭");
			}
		}
		button4.setClickListener(new MouthListener());

		button4.click();

	}

}
