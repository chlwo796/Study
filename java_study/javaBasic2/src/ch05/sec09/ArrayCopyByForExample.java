package ch05.sec09;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
//		�迭����
		int[] oldArray = {1, 5, 7};
		int[] newArray = new int[5];
		
		for(int i = 0; i<oldArray.length;i++) {
			newArray[i] = oldArray[i];
	
		}
		for(int i = 0; i<newArray.length;i++) {
			System.out.print(newArray[i] + "\t");	// oldArray�� ���̸�ŭ ���� �迭�� �ε����� �迭����. �� �� ���ڸ��� �ʱⰪ����
		}
		
	}

}
