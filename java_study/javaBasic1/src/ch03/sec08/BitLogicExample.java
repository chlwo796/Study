package ch03.sec08;

public class BitLogicExample {

	public static void main(String[] args) {
		// 비트 논리연산자. 2진수로 연산한다. 각 자리수 비교. 1 = true, 0 = false
		// & = 각 자리수 모두 1일 경우 true
		// | = 둘 중 하나라도 1일 경우 true
		// ^ = 서로 다르다면 true
		// ~ = 각 자리수 모두 0일 경우 true. & 반대연산.
		// true, false로 나온 0과 1을 합산해 다시 10진수로 변환한다.

		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));
		System.out.println("-----------------------");

		// 서로 다른 데이터타입을 가진 프로그램 사이에 데이터를 주고받는 경우
		// 비트논리연산자가 필요하다.

		byte receiveData = -128; // C언어의 허용범위가 0~255까지인 경우
		int unsignedInt1 = receiveData & 255; // java byte타입의 데이터 -128에 허용범위인 255를 곱연산 해주면
		System.out.println(unsignedInt1); // C언어의 허용범위에서 사용가능한 데이터추출이 가능하다

		int unsignedInt2 = Byte.toUnsignedInt(receiveData); // java api를 이용한 자동 연산
		System.out.println(unsignedInt2);

		int test = 136;
		byte btest = (byte) test;
		System.out.println(btest); // Overflow 개념확인

	}

}
