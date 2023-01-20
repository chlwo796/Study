package ch03.sec01;

public class IncreaseDecreaseOperatorExample {

	public static void main(String[] args) {
		// 증감 연산자

		int x = 10;
		int y = 10;
		int z;

		x++;
		++x;
		System.out.println(x);
		System.out.println(x++);	//여기서 위에서 받아온 x값을 먼저 출력 후 1을 더해 연산한다.

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
