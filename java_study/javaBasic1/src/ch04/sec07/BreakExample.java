package ch04.sec07;

public class BreakExample {

	public static void main(String[] args) {
//		while 이용, 주사위 번호를 반복출력, 6이 나오면 좋료.
		
		System.out.println("주사위 프로그램");
		while(true) {
			int number = (int)((Math.random()*6)+1);
			System.out.println(number + "이 나왔습니다.");
			if(number == 6) {
				System.out.print("종료하겠습니다.");
				break;
			}
		}
	}

}
