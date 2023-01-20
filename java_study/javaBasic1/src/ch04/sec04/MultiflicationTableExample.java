package ch04.sec04;

public class MultiflicationTableExample {

	public static void main(String[] args) {
//		구구단 프로그램

		for (int i = 2; i <= 9; i++) {
			System.out.println("****" + i + "단****");
			for (int j = 1; j <= 9; j++) {
				int k = i*j;
				System.out.println(i + " X " + j + " = " + k);
			}
		}

	}

}
