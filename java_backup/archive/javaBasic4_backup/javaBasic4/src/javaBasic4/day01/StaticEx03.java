package javaBasic4.day01;

public class StaticEx03 {

	static boolean a = true;
	static float b = 2.56f;
	static double c = 78.56;

	String city = "����";
	int age = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(a + " " + b + " " + c);
		StaticEx03 st03 = new StaticEx03();
		System.out.println(st03.city + " " + st03.age);
		
		st03.printA();
	}

	// �ν��Ͻ� �޼ҵ�
	public void printA() {
		System.out.println(a + " " + b + " " + c);
		System.out.println(city + " " + age);
	}
}