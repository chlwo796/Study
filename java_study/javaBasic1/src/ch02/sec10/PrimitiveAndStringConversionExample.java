package ch02.sec10;

public class PrimitiveAndStringConversionExample {

	public static void main(String[] args) {
		// 문자열을 기본 타입으로 변환
		// String str = String.valueOf(기본타입값);
		int value1 = Integer.parseInt("10");		// 10이라는 문자열을 integer 타입으로 value1 에 저장.
		double value2 = Double.parseDouble("3.141592");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.141592);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
