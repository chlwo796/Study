package ch05.sec06;

public class ArrayCreateByNewExample {

	public static void main(String[] args) {
//		�迭���� ����� �迭 ����
		
		int[] intArray = new int[3];
		
		for(int i = 0;i<intArray.length; i++) {
			System.out.println(intArray[i]);
		}
//		������ �迭�� �ʱⰪ Ȯ��
		
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
//		doubleŸ���� �ʱⰪ Ȯ��
		
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
		
		stringArray[0] = "����";
		stringArray[1] = "ȣ����";
		stringArray[2] = "��";
		
		for(int i = 0;i<stringArray.length;i++) {
			System.out.println(stringArray[i]);
		}
		
	}

}
