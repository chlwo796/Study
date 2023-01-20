package ch05.day04;

import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
//		2. 배열을 먼저 만들어두고 나중에 값을 넣기

		int[] a1 = new int[5]; // 5칸의 배열을 먼저 만들어놓음(0~4)
		a1[0] = 10;
		a1[1] = 20;
		a1[2] = 30;
		a1[3] = 40;
		a1[4] = 50;
//		a1[5] = 60;	// arrayindexoutofbounds error

//		for (int a : a1) {
//			System.out.print(a + "\t");
//		}
//		키보드로 정수 5개 입력받고 합 구하기

//		Scanner sc = new Scanner(System.in);
//		int[] a2 = new int[5];
//		int sum = 0;
//		for(int i = 0; i<a2.length; i++) {
//			System.out.print((i+1) + "번째 숫자 입력>");	// 5번을 입력받는다.
//			a2[i] = sc.nextInt();
//			sum = sum + a2[i];
//		}
//		System.out.println(sum);

//		입력받은 숫자중에서 가장 큰 숫자는?
//		가장 작은숫자는?
		Scanner sc = new Scanner(System.in);

//		int[] a3 = new int[5];
//		int max = 0;
//		int min = 0; // 집에가서 초기값 설정 공부해보기
//		for (int i = 0; i < a3.length; i++) {
//			System.out.print((i + 1) + "번째 숫자 입력>");
//			a3[i] = sc.nextInt();
//			if (max <= a3[i]) {
//				max = a3[i];
//			}	
//			if (min >= a3[i] || min == 0) {	// min == 0 조건을 하나 추가해서 초기값이 0이더라도 min = a3[0]이 실행되도록 함..
//				min	= a3[i];	// 입력할 숫자들 중에서 min(0)이 항상 작을 것임. 실행은 되지만 결과값은 계속 0
//			}
//		}
//		System.out.println(max);
//		System.out.println(min);

		System.out.println();

//		작은 숫자부터 정렬하기
		int[] a4 = new int[5];

		int temp;

		for (int i = 0; i < a4.length; i++) {
			System.out.print((i + 1) + "번째 숫자 입력>"); // 5번을 입력받는다.
			a4[i] = sc.nextInt();
		}
		System.out.print("0회정렬 =>");
		for (int a : a4) {
			System.out.print(a + "\t");
		}
		for (int i = 0; i < a4.length - 1; i++) {
			System.out.print("\n" + (i + 1) + "회 정렬 =>");

			for (int j = i; j < a4.length; j++) { // i의 반복회차가 증가할 때 j = i 라는 식에서 j의 실행횟수를 줄인다.
				if (a4[i] > a4[j]) { // i = j = 0일때 초기값 a4[0]과 a4[0]에서는 어떤 연산도 이루어 지지않는다.!!!
					temp = a4[i];
					a4[i] = a4[j];
					a4[j] = temp;
//						System.out.println(j + "회 완료");
//					System.out.println((j+1) + "회 정렬 =>");
//					for (int a : a4) {
//						System.out.print(a + "\t");
//					}
				}
			}
			for (int a : a4) {
				System.out.print(a + "\t");
			}

		}
	}

}
