package ch05.day04;

public class ArrayEx01 {

	public static void main(String[] args) {
//		Array

		int[] a1; // 두가지 방법으로 변수를 선언할 수 있는데 첫번째 방식이 대중적임
		int a2[];

//		a2 = 10;	// 10이라는 값이 배열의 어느 주소로 들어갈지 몰라서 에러가 남
		a2 = null; // 참조변수 가능

//		배열 안에 값을 넣는 방법
//		1. 초기값으로 넣기, 2. 배열 만들어 놓고 필요하면 넣어준다
		int[] a3 = { 1, 2, 3, 4, 5, 6 }; // 0~5열까지 생성된다.
		System.out.println(a3[3]); // 3열
		System.out.println(a3[5]); // 5열

//		문제1. 1.1,3.3,5.4,10.3,8.9,11.23
//		10.3- 3.3 하기

		double[] a4 = { 1.1, 3.3, 5.4, 10.3, 8.9, 11.23 };
		double a5 = (a4[3] - a4[1]);
		System.out.println(Math.round(a5)); // Math.round(); = 소수점을 자른다.

//		문제2. true, false, false, true, true, false, false, true
//		제일 마지막에 있는 true 찍기.

		boolean[] a6 = { true, false, false, true, true, false, false, true };
		System.out.println(a6[7]);

//		문제3. "돈가스", "김밥", "떡볶이", "피자" 출력은 김밥, 떡볶이 출력

		String[] a7 = { "돈까스", "김밥", "떡볶이", "피자" };
		System.out.println(a7[1] + ", " + a7[2]);

//		배열에 index를 대입하여 값을 골라서 출력하는 것이 아닌
//		반복문을 이용한 변수 한번에 출력하기
//		.length = method가 아닌 속성

		System.out.println("a3 배열의 길이(크기) = " + a3.length);

		for (int i = 0; i < a3.length; i++) { // i < 6 이 아닌 배열의 크기를 대입해서 실행
			System.out.print(a3[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < a4.length; i++) {
			System.out.print(a4[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < a6.length; i++) {
			System.out.print(a6[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < a7.length; i++) {
			System.out.print(a7[i] + " ");
		}
		System.out.println();
		
//		향상된 for 활용(Datatype variable : arrayname) 배열에 있는 원소를 한개씩 꺼내서 앞에 변수에 넣는다.
//		마지막까지 꺼내서 변수 넣어주면 더 이상 반복하지 않는다.
//		배열 타입[]을 다시 적지 않는다.
		
		for(int a : a3) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(double a : a4) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(boolean a : a6) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for(String a : a7) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
