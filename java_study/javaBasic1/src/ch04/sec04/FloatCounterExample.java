package ch04.sec04;

public class FloatCounterExample {

	public static void main(String[] args) {
//		float타입의 for문

		for (float i = 0.1f; i <= 1f; i += 0.1f) {
			System.out.println(i);
		}
//		출력결과를 보면 9번만 실행되는 것을 알 수 있다. 그 이유는,
//		부동소수점방식의 float타입은 0.1이 아닌 0.1보다 약간 더 큰 값을 가지므로 10번째 i값은 1.0보다 조금 더 크기 때문이다.
//		for문에서 float타입의 사용은 하지 않는 것이 좋다.
	}

}
