package ch02.sec04;

public class FloatDoubleExample {
	
	public static void main(String[] args) {
		// Float, Double = �Ǽ�Ÿ��
		float a = 0.1234567890123456789f;		// float Ÿ�Կ��� �ڿ� 'f'�� �Է��Ѵ�.
		double b = 0.1234567890123456789;
		
		System.out.println(a);
		System.out.println(b);		// ��°����� ���� Ȯ�� ����, double Ÿ���� float Ÿ�Ժ��� �� 2���� ��ȿ�ڸ����� ������.
		
		// e, E = 10�� �ŵ����� Literal
		float c = 6e4f;		//6*10*10*10*10
		double d = 6e4;
		double e = 5e-2;	//5*0.1*0.1
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}

}
