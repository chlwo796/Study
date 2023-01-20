package ch05.sec03;

public class ReferenceVariableCompareExample {

	public static void main(String[] args) {

		int[] array1;
		int[] array2;
		int[] array3;

		array1 = new int[] { 1, 2, 3 };
		array2 = new int[] { 1, 2, 3 };	// 내용이 같다고 해서 같은 주소로 생기는 것이 아니다.
		
		array3 = array2;	//array3 에 array2의 주소를 대입
		
		System.out.println(array1 == array2);
		System.out.println(array2 == array3);
		System.out.println(array1);
		System.out.println(array2);
		System.out.println(array3);
		
//		stack memory에는 array1, array2, array3 변수가 int[]타입으로 형성되있다.
//		heap memory에는 배열 {1, 2, 3}인 객체가 각각 array1, array2에 참조한다.(같은 주소x)
//		그래서 array1 == array2는 false가 출력된다.
	}
}
