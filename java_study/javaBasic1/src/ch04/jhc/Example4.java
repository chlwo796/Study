package ch04.jhc;

public class Example4 {

	public static void main(String[] args) {
//		while, Math.random(), 두개의 주사위를 던졌을 때 나오는 눈을 (a, b)형태로 출력하고 합이 5면 실행종료

//		System.out.println(Math.random());	// 0~0.9999999까지 출력
//		System.out.println((Math.random()*6));	// 0~5.9999
//		System.out.println((int)(Math.random()*6));	// 0~5
//		System.out.println((int)((Math.random()*6))+1);	// 주사위 세팅 완료

		int a = 0;
		int b = 0;
		while (a+b !=5) {
			a = (int) ((Math.random() * 6)) + 1;
			b = (int) ((Math.random() * 6)) + 1;
			System.out.println("(" + a + ", " + b + ")");
		}

	}

}
