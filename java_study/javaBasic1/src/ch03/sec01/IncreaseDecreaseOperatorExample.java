package ch03.sec01;

public class IncreaseDecreaseOperatorExample {

	public static void main(String[] args) {
		// ���� ������

		int x = 10;
		int y = 10;
		int z;

		x++;
		++x;
		System.out.println(x);
		System.out.println(x++);	//���⼭ ������ �޾ƿ� x���� ���� ��� �� 1�� ���� �����Ѵ�.

		System.out.println("------------");
		y--;
		--y;
		System.out.println(y);

		System.out.println("------------");
		z = x++;
		++x;
		System.out.println("z :" + z);
		System.out.println("x :" + x);

		System.out.println("------------");
		z = ++x;
		System.out.println("z :" + z);
		System.out.println("x :" + x);

		System.out.println("------------");
		z = x++ + y++;
		++x;
		System.out.println("z :" + z);
		System.out.println("x :" + x);
		System.out.println("y :" + y);

		System.out.println("------------");

	}

}
