package javaMid7.ex04;

public class AnonymousMain {

	public static void main(String[] args) {
//		�� ������ ȭ���� ������ �� ����ϴ� �����̴�.
		Button button1 = new Button();

		class OKListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("OK��ư�� Ŭ���߽��ϴ�.");
			}
		}
		button1.setClickListener(new OKListener());

		button1.click();

		Button button2 = new Button();
		class CancleListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("cancle��ư Ŭ��");

			}
		}
		button2.setClickListener(new CancleListener());

		button2.click();

		Button button3 = new Button();
		class SpaceBarListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("SpaceBar��ư Ŭ��");
			}
		}
		button3.setClickListener(new SpaceBarListener());

		button3.click();

		Button button4 = new Button();

		class MouthListener implements Button.ClickListener {
			@Override
			public void onClick() {
				System.out.println("Mouth��ư Ŭ��");
			}
		}
		button4.setClickListener(new MouthListener());

		button4.click();

	}

}
