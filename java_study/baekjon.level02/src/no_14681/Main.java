package no_14681;

//���� ���� ���� �� �ϳ��� �־��� ���� ��� ��и鿡 ���ϴ��� �˾Ƴ��� ���̴�. 
//��и��� �Ʒ� �׸�ó�� 1���� 4���� ��ȣ�� ���´�. "Quadrant n"�� "��n��и�"�̶�� ���̴�.
//���� ���, ��ǥ�� (12, 5)�� �� A�� x��ǥ�� y��ǥ�� ��� ����̹Ƿ� ��1��и鿡 ���Ѵ�. 
//�� B�� x��ǥ�� �����̰� y��ǥ�� ����̹Ƿ� ��2��и鿡 ���Ѵ�.
//���� ��ǥ�� �Է¹޾� �� ���� ��� ��и鿡 ���ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. 
//��, x��ǥ�� y��ǥ�� ��� ����� ������� �����Ѵ�.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
//		(+,+) ->1,(-,+) -> 2, (-,-) -> 3, (+,-) -> 4
		
		if(x>0 && y>0) {
			System.out.println(1);
		}else if(x<0 && y>0) {
			System.out.println(2);
		}else if(x<0 && y<0) {
			System.out.println(3);
		}else {
			System.out.println(4);
		}
	}
}
