package no_10950;

//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int count, a, b;
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a + b);
		}
	}
}
