package ch05.sec05;

public class ReplaceExample {

	public static void main(String[] args) {
//		대체하기 = .replace("a", "b") a->b
		
		String A = "최재환";
		String newA = A.replace('환', '남');	// A를 참조하는 것이 아닌 새로운 String객체를 생성
		
		System.out.println(A);
		System.out.println(newA);
		
		System.out.println(A==newA);		// 새로운 객체가 생성된것을 확인.
		System.out.println(!A.equals(newA));	// 문자열이 다름을 확인

	}

}
