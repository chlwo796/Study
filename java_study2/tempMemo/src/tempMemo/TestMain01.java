package tempMemo;

import java.util.Scanner;

public class TestMain01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int num = sc.nextInt();
		int count = 0;
		while (true) {
			count++;
			sum += count;
			if (num == count) {
				System.out.println(sum);
				break;
			}
		}
	}
}
