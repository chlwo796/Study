package javaChap12.example04;

public class ValueCompareExample {
	public static void main(String[] args) {
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println(obj1==obj2);
		System.out.println(obj1.equals(obj2));
		
		Integer obj3 = 100;
		Integer obj4 = 100;
		System.out.println(obj3==obj4);	// -128~127의 범위에서의 결과를 확인해볼 수 있다.
		System.out.println(obj3.equals(obj4));
	}
}
