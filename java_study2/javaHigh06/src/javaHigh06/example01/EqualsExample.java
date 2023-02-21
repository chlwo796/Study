package javaHigh06.example01;

import java.io.IOException;

public class EqualsExample {
	public static void main(String[] args) throws IOException {
		System.out.println("기본");
		System.err.println("에러용 빨간색");

		try {
			while (true) {
				int val = Integer.parseInt("100");
				int readData = System.in.read();
				if (readData == 78 || readData == 100) {
					System.out.println("정상종료");
					System.exit(0);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
}
