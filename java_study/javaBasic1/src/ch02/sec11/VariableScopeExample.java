package ch02.sec11;

public class VariableScopeExample {

	public static void main(String[] args) {
		// 변수 사용 범위
		// int v1 = 15;
		// if(v1>15) {
		// int v2 = v1-10; // if문에 {} 안에서 선언된 변수 v2는 해당 중괄호{}에서만 사용이 가능하다.
		// }
		// int v3 = v1 + v2 +5;

		// System.out.println(v1); // 외부 main method{}에서 선언된 실행문에 v2라는 변수는 지정되지 않는다.
		// method block 전체에서 사용하고 싶으면 method block 첫머리에 선언하는 것이 좋다.
		int v1 = 15;
		int v2 = v1 - 10;
		int v3 = v1 + v2 + 5;

		if (v1 > 10) {
			v2 = v1 + 5;
		}
		System.out.println(v3);		//정상적으로 실행되도록 다시 코딩함.
	}

}
