package ch02.sec08;

public class CastingExample {

	public static void main(String[] args) {
		// ��������ȯ = Casting
		int intValue = 100;
		byte byteValue = (byte) intValue;	//byte�� ������ �ʰ�������� ��� ����Ǵ°��ϱ�? 200->-56
		
		System.out.println(byteValue);
		
		long longValue = 5239;
		intValue = (int) longValue;
		
		System.out.println(intValue);

		intValue = 84;
		char charValue = (char) intValue;
		
		System.out.println(charValue);		//�ƽ�Ű�ڵ� ����
		
		double doubleValue = 1.89764;
		intValue = (int) doubleValue;
		
		System.out.println(intValue);
	}

}
