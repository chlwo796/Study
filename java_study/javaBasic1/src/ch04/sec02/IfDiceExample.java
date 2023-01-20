package ch04.sec02;

public class IfDiceExample {

	public static void main(String[] args) {
		// 주사위에서 나온 숫자를 출력하는 프로그램
		int a = (int) ((Math.random()*6)+1);
		
		if(a == 1) {
			System.out.println("1번이 나왔습니다");
		}
		else if(a == 2) {
			System.out.println("2번이 나왔습니다");
		}
		else if(a == 3) {
			System.out.println("3번이 나왔습니다");
		}
		else if(a == 4) {
			System.out.println("4번이 나왔습니다");
		}
		else if(a == 5) {
			System.out.println("5번이 나왔습니다");
		}else {
			System.out.println("6번이 나왔습니다");
		}
	}

}
