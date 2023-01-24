package ch05.sec06;

public class ArrayCreateByValueListExample1 {

	public static void main(String[] args) {
//		배열의 선언
		String[] array1 = { "호랑이", "사자", "개", "고양이" };

		System.out.println(array1[0]);
		System.out.println(array1[1]);
		System.out.println(array1[2]);
		System.out.println(array1[3]);

		array1[1] = "토끼"; // 새로운 value를 배열의 위치를 지정해서 대입

		System.out.println(array1[1]);

		int[] array2 = { 40, 50, 60 };
		int sum = 0;
		for (int i = 0; i < array2.length; i++) {
			sum = sum + array2[i];
		}
		int ave = sum / array2.length;

		System.out.println(sum + "\t" + ave);
	}

}
