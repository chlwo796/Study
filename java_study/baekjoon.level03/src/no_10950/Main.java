package no_10950;

//�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
