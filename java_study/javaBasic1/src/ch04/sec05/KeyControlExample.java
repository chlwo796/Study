package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {

	public static void main(String[] args) {
//		1,2를 입력했을 때 속도를 증속,감속시키고 3을 입력하면 실행종료하는 프로그램
		Scanner sc = new Scanner(System.in);
		int speed = 0;
		
		while(true) {
			System.out.println("-----------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("-----------------------");
			System.out.println("선택>");
			int key = sc.nextInt();

			if(key == 1) {
				speed = speed + 1;
				System.out.println("현재 속도 =" + speed);
			}else if(key == 2) {
				speed = speed -1;
				System.out.println("현재 속도 =" + speed);
			}else break;
		}
		System.out.println("종료");
//		break;를 사용하지 않고는 boolean 변수를 따로 선언하여 true<->false로 while문을 컨트롤 할 수 있다.
	}

}
