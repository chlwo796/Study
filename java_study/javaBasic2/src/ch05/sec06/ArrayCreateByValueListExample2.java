package ch05.sec06;

public class ArrayCreateByValueListExample2 {

	public static void main(String[] args) {
//		배열에 값을 지정할 때의 주의사항.
//		배열변수를 값을 대입하기 이전에 미리 선언했다면, 그 이후로는 직접적으로 값을 대입할 수 없다.

//		int[] array = null;
//		array = {1,2,3,4};	// 오류발생. 값 지정은 선언과 동시에 이루어져야 한다.

//		그 이후에 값을 직접 넣고 싶다면 배열을 새로 만들어야한다.

		int[] array = null;
		System.out.println(array); // 초기값 지정

		array = new int[] { 1, 2, 3, 4, 5 }; // 선언 이후 값을 넣어준다.
		for (int a : array) { // 향상된 for로 출력
			System.out.println(a + " ");
		}

		int[] array1;
		int sum = 0;
		array1 = new int[] { 1, 23, 4, 5, 9 };

		for (int i = 0; i < array1.length; i++) {
			sum = sum + array1[i];
		}
		System.out.println(sum);
		printItem(new int[8]);
	}

	private static void printItem(int[] array1) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
	}

}
