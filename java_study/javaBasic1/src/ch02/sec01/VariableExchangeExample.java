package ch02.sec01;

public class VariableExchangeExample {

	public static void main(String[] args) {
		
		int x = 3;
		int y = 5;
		swap(x, y); //x = 3, y = 5 ��� value �� ������ �Ʒ� swap method ȣ��
		
		System.out.println("x:" + x + ", y:" + y);
		
		int bkor = 0b1011;
		
		System.out.println(bkor);
	}//end main()
	
	static void swap(int x,int y) {//x = 3, y = 5 ��� value�� ����
		int temp = y; // temp��� ���ο� ���� ����.
		y = x;
		x = temp;
		
		System.out.println("x:" + x + ", y:" + y + " �� ���� swap method");
		
		/*
		byte kor = 100;		// 1byte = 8bit, bit�� 0�� 1�� ����Ǵ� ����
		short eng = 85;		// 2byte = 16bit
		char asd = "��ȯ";	// 2byte, ���ڸ� ��� ������������, ��ü�� ������. �ƽ�Ű�ڵ�.
		int mat = 90;		// 4byte = 32bit, ���� ���� ���� ����Ÿ��.
		long sci = 86;		// 8byte = 64bit
		byte kor1 = 89;
		
		int total = kor + kor1; //1byte + 1byte = 1byte ��Ģ������ ��ȣ�� 4byte�� �����Ѵ�.
		*/

	}

}//end class

//���� �ڵ�