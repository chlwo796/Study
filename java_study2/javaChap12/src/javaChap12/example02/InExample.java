package javaChap12.example02;

import java.io.IOException;

public class InExample {
	public static void main(String[] args) throws IOException {
		int speed = 0;
		int keyCode = 0;

		while (true) {
			if (keyCode != 13 && keyCode != 10) {
				if (keyCode == 49) {
					speed++;
				} else if (keyCode == 50) {
					speed--;
				} else if (keyCode == 51) {
					break;
				}
				System.out.println("-----------------------");
				System.out.println("1. ���� | 2. ���� | 3. ����");
				System.out.println("------------------------");
				System.out.println("����ӵ�>" + speed);
				System.out.print("����>");
			}
			keyCode = System.in.read();

		}
	}
}
