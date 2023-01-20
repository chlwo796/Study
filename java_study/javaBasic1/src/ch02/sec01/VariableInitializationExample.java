package ch02.sec01;

public class VariableInitializationExample {

	public static void main(String[] args) {

		// int value;// 변수 value를 선언
		
		// int result = value + 10; // 변수 result에 변수 value + 10 의 값을 넣어줌
		
		// System.out.println(result);	// 변수 result 출력

		// Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		// The local variable value may not have been initialized
		
		// 이 컴파일 오류는 value라는 변수의 값이 초기화되지 않아서 생기는 오류이다.
		
		int value = 5; // 이처럼 value라는 변수에 5라는 값을 초기화하여
		
		int result = value + 6; // 변수 result에 넣어준다.
		
		System.out.println(result); //정상작동
		

	}

}
