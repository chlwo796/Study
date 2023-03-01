package javaChap12.exercise12;

public class IntegerCompareExample {
	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;

		System.out.println(obj1 == obj2);	// 제한범위 -128~127에서는 포장객체도 값으로 비교한다.
		System.out.println(obj3.equals(obj4));	// 객체의 값만 비교
	}
}
