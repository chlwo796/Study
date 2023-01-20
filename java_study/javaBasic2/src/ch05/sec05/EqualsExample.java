package ch05.sec05;

public class EqualsExample {

	public static void main(String[] args) {
//		String 비교

		String strA = "최재환";
		String strB = "최재환";

		if (strA == strB) {
			System.out.println("A와 B는 참조가 같다");
		} else {
			System.out.println("A와 B는 참조가 다르다");
		}
		if (strA.equals(strB)) {
			System.out.println("A와 B는 문자열이 같다");
		} else {
			System.out.println("A와 B는 문자열이 다르다");
		}
		String strC = new String("최재환");
		String strD = new String("최재환");
		
		if (strC == strD) {
			System.out.println("C와 D는 참조가 같다");
		} else {
			System.out.println("C와 D는 참조가 다르다");
		}
		if (strC.equals(strD)) {
			System.out.println("C와 D는 문자열이 같다");
		} else {
			System.out.println("C와 D는 문자열이 다르다");
		}
		
//		strC와 srtD의 객체를 따로 만든 후 같은 문자열을 대입하면 서로 참조주소는 다르다.
	}

}
