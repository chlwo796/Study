package ch02.sec09;

public class OperationPromotionExample {
	
	public static void main(String[] args) {
		// ����� �ڵ�����ȯ
		byte result1 = 10 + 20;
		
		System.out.println(result1);
		
		byte v1 = 10;
		byte v2 = 20;
		int result2 = v1 + v2;
		
		System.out.println(result2);
		
		byte v3 = 14;
		int v4 = 52;
		long v5 = 18439L;
		long result3 = v3 + v4 + v5;
				
		System.out.println(result3);
		
		char v6 = '��';
		char v7 = 2;
		int result4 = v6 +v7;
		
		System.out.println(result4);
		System.out.println((char)result4);
		
		int v8 = 2300;
		int result5 = v8*12/98;
		
		System.out.println(result5);
		
		int v9 = 2764;
		double result6 = v9*3.0;
		
		System.out.println(result6);
		
		int v10 = 3;
		int v11 = 5;
		double result7 = (double)v10/v11;	//(double)�� ��������ȯ�� ���ִ� ������ int�� ���� �� �Ҽ����ڸ��� �ƿ�����. -> 0 ���
		
		System.out.println(result7);

	}

}