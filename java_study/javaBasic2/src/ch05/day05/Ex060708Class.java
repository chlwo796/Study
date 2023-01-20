package ch05.day05;

public class Ex060708Class {

	public static void main(String[] args) {
//		확인문제6번 출력결과 예상

		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		System.out.println(array.length); // 3
		System.out.println(array[2].length); // 5
		System.out.println(array[1].length);
//		확인문제 7번 최대값 구하기(for)

		int[] array1 = { 1, 5, 3, 8, 2 };
		int max = 0;
		for (int i = 0; i < array1.length-1; i++) {
			if (max <= array1[i]) {
				max = array1[i];
			}
		}
		System.out.println(max);

//		확인문제 8번 array 전체 합과 평균 구하기(중첩 for)

		int sum = 0;
		int count = 0; // count 변수를 내부 for 실행될 때마다 count++ 방법도 있다!!
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum = sum + array[i][j];
			}
			count = count + array[i].length;
		}

		System.out.println(sum);
		System.out.println((double) (sum / count));

	}

}
