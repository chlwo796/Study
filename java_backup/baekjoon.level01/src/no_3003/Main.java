package no_3003;

//�����̴� ������ â�� �����ٰ� ���� ü���ǰ� �ǽ��� �߰��ߴ�.
//ü������ ������ �о�� �ɷ��� ������ �׷����� ������ ü������ �Ǿ���. ������, ������ �ǽ��� ��� �־�����, ��� �ǽ��� ������ �ùٸ��� �ʾҴ�.
//ü���� �� 16���� �ǽ��� ����ϸ�, ŷ 1��, �� 1��, �� 2��, ��� 2��, ����Ʈ 2��, �� 8���� �����Ǿ� �ִ�.
//�����̰� �߰��� ��� �ǽ��� ������ �־����� ��, �� ���� ���ϰų� ���� �ùٸ� ��Ʈ�� �Ǵ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a, b, c, d, e, f;
		int king, queen, look, vishop, knight, phon;
		king = 1;
		queen = 1;
		look = 2;
		vishop = 2;
		knight = 2;
		phon = 8;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		f = sc.nextInt();

		System.out.println((king - a) + " " + (queen - b) + " " + (look-c) + " " + (vishop-d) + " " + (knight-e) + " " + (phon-f));
	}
}
