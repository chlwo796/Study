package ch02.sec07;

public class PromotionExample {

	public static void main(String[] args) {
		// �ڵ� ����ȯ(promotion)
		byte byteValue = 100;
		int intValue = byteValue;	// intŸ���� byteŸ�Ժ��� �޸�ũ�Ⱑ �� ũ�⶧���� �ڵ����� ����ȯ ����
		
		System.out.println(intValue);
		
		char charValue = '��';		
		intValue = charValue;		// intŸ���� charŸ�Ժ��� �޸� ũ�Ⱑ �� ŭ.
		
		System.out.println(intValue);	//charValue �� �����ڵ� ���.
		
		intValue = 120;
		long longValue = intValue;
		
		System.out.println(longValue);
		
		longValue = 200;
		float floatValue = longValue;
		
		System.out.println(floatValue);
		
		floatValue = 15.124F;
		double doubleValue = floatValue;
		
		System.out.println(doubleValue);

	}

}
