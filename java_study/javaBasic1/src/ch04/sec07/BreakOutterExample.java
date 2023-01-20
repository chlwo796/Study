package ch04.sec07;

public class BreakOutterExample {

	public static void main(String[] args) {
//		중첩된 반복문의 break;
		System.out.println((int) 'A');
		System.out.println((int) 'Z'); // A~Z = 65~90
		System.out.println((int) 'a');
		System.out.println((int) 'z'); // a~z = 97~122
		System.out.println((int) 'g');

		Outter: for (char i = 'A'; i <= 'Z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				System.out.println(i + " - " + j);
				if (j == 'g') {

					break Outter;
				}

			}
		}
//		for문에는 char도 증감식으로 연산이 바로 가능하다.
//		내부에 break;를 중첩하지 않고 한번에 종료하려면 
//		종료하고 싶은 상위 반복문에 `name: `이후 break name;
	}

}
