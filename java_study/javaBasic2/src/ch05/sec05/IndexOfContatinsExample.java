package ch05.sec05;

public class IndexOfContatinsExample {

	public static void main(String[] args) {
//		문자열찾기 = .indexOf(), .contains()
//		.indexOf() = 포함되어 있으면 해당 위치, 해당 문자가 포함되어 있지 않으면 -1을 return
//		.contains() = 포함되어 있으면 true, 그렇지 않으면 false를 return
		
		String strA = "자바 프로그래밍";
		
		int indexA = strA.indexOf("프로그래밍");
		System.out.println(indexA);
		
		String substringA = strA.substring(indexA);
		System.out.println(substringA);
		
		int indexB = strA.indexOf("자바");
		if(indexB != -1) {
			System.out.println("자바와 관련된 책입니다.");
		}else {
			System.out.println("자바와 관련된 책이 아닙니다.");
		}
		
		boolean x = strA.contains("자바");
		
		if(x) {
			System.out.println("자바와 관련된 책입니다.");
		}else {
			System.out.println("자바와 관련된 책이 아닙니다.");
		}
		
//		두 가지 방법 중 편한 방법을 사용해보자.
	}

}
