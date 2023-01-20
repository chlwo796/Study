package ch04.sec03;

public class SwitchExample {

	public static void main(String[] args) {
//		Switch-case로 주사위 번호 출력

		int a = (int) ((Math.random() * 6) + 1);
		System.out.println(a);
		switch (a) {
		case 1:
			System.out.println(a + "번입니다");
			break;
		case 2:
			System.out.println(a + "번입니다");
			break;
		case 3:
			System.out.println(a + "번입니다");
			break;
		case 4:
			System.out.println(a + "번입니다");
			break;
		case 5:
			System.out.println(a + "번입니다");
			break;
		default:
			System.out.println(a + "번입니다");
		}

	}

}
