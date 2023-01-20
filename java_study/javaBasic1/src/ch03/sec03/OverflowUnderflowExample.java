package ch03.sec03;

public class OverflowUnderflowExample {

	public static void main(String[] args) {
		// 오버플로우와 언더플로우

		byte var1 = 125;
		for (int i = 0; i < 5; i++) {
			var1++;
			System.out.println(var1);		// Overflow. byte 타입의 최대허용범위 127에서 1을 더하면 최소값인 -128 이 출력된다.
		}
		System.out.println("------------");

		byte var2 = -125;
		for (int i = 0; i < 5; i++) {
			var2--;
			System.out.println(var2);		// Underflow. byte 타입의 최소허용범위 -128에서 1을 빼면 최대값인 127이 출력된다.
		}
	}

}
