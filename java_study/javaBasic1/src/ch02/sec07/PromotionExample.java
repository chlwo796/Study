package ch02.sec07;

public class PromotionExample {

	public static void main(String[] args) {
		// 자동 형변환(promotion)
		byte byteValue = 100;
		int intValue = byteValue;	// int타입이 byte타입보다 메모리크기가 더 크기때문에 자동으로 형변환 가능
		
		System.out.println(intValue);
		
		char charValue = '최';		
		intValue = charValue;		// int타입이 char타입보다 메모리 크기가 더 큼.
		
		System.out.println(intValue);	//charValue 의 유니코드 출력.
		
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
