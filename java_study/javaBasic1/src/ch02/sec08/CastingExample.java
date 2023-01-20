package ch02.sec08;

public class CastingExample {

	public static void main(String[] args) {
		// 강제형변환 = Casting
		int intValue = 100;
		byte byteValue = (byte) intValue;	//byte의 범위를 초과했을경우 어떻게 연산되는것일까? 200->-56
		
		System.out.println(byteValue);
		
		long longValue = 5239;
		intValue = (int) longValue;
		
		System.out.println(intValue);

		intValue = 84;
		char charValue = (char) intValue;
		
		System.out.println(charValue);		//아스키코드 참조
		
		double doubleValue = 1.89764;
		intValue = (int) doubleValue;
		
		System.out.println(intValue);
	}

}
