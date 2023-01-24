package ch05.sec06;

public class ArrayCreateByNewExample {

	public static void main(String[] args) {
//		배열변수 선언과 배열 생성
		
		int[] intArray = new int[3];
		
		for(int i = 0;i<intArray.length; i++) {
			System.out.println(intArray[i]);
		}
//		정수형 배열의 초기값 확인
		
		intArray[0] = 1;
		intArray[1] = 3;
		intArray[2] = 5;
		
		for(int i = 0;i<intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		double[] doubleArray = new double[3];
		for(int i = 0;i<doubleArray.length;i++) {
			System.out.println(doubleArray[i]);
		}
//		double타입의 초기값 확인
		
		doubleArray[0] = 0.1;
		doubleArray[1] = 0.5;
		doubleArray[2] = 1.1;
		
		for(int i = 0;i<doubleArray.length;i++) {
			System.out.println(doubleArray[i]);
		}
		String[] stringArray = new String[3];
		
		for(int i = 0;i<stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		
		stringArray[0] = "사자";
		stringArray[1] = "호랑이";
		stringArray[2] = "개";
		
		for(int i = 0;i<stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		
	}

}
