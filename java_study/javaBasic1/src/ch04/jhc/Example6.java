package ch04.jhc;

public class Example6 {

	public static void main(String[] args) {
//		for * Ʈ�� �����

		for (int i = 1; i <= 50; i+=2) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
