package ch05.sec04;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
//		Null

		String str1 = "자바";
		String str2 = null;

		System.out.println(str1 == str2);
		System.out.println(str1 != str2);
		
		int[] array1 = null;	// null이라는 값은 초기값으로 사용이 가능하다. 따라서 heap memory에 주소를 생성하지 않고 바로 stack에 생성된다.
//		array1[0] = 10;			// 그래서 array1 배열의 0자리에 10을 대입하면 에러가 발생한다. 
								// int[] array1 배열에 참조할 heap memory 주소(배열객체)가 없음.
//		System.out.println(array1);	// NullPointerExceptionExample
		
		String str3 = null;		// null값을 str2에 대입
//		System.out.println(str3.length());	// 문자열의 길이를 호출하는 method .length();를 실행했지만 오류발생
		
	}

}
