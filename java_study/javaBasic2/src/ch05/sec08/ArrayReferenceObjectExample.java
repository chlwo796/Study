package ch05.sec08;

public class ArrayReferenceObjectExample {

	public static void main(String[] args) {
//		�����迭
		
		String[] strArray = new String[3];
		
		strArray[0] = "�ڹ�";
		strArray[1] = "�ڹ�";
		strArray[2] = new String("java");	// stack�� �ƴ� heap�� �ּҸ� ������
		
		System.out.println(strArray[0] == strArray[1]);
		System.out.println(strArray[1] == strArray[2]);		// strArray[2]�� ���ο� ��ü�� �����ϴµ� �� ���� java�� ���̴�. �׷��� false
		System.out.println(strArray[0].equals(strArray[2]));
		
		System.out.println(strArray.length);
		System.out.println(strArray[2]);
		
		System.out.println(strArray);
		
	}

}
