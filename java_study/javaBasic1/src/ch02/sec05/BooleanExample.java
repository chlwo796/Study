package ch02.sec05;

public class BooleanExample {

	public static void main(String[] args) {
		boolean a = true;
		if(a) {
			System.out.println("중지합니다.");
		}else {
			System.out.println("시작합니다.");
		}
		
		int b = 10;
		boolean result1 = b==10;
		boolean result2 = b!=10;
		
		System.out.println(result1);
		System.out.println(result2);

	}

}
