package javaBasic4.day01;

public class StaticEx02 {
	// Static ������ ������ ����ؾ� �Ѵ�. �޸� ȿ��x
	// ���α׷� �����ֱ�(Life Cycle) ���� - Ȱ�� - �Ҹ�
	static int a = 100; // ��������, ���α׷� ������ �� ����, ���α׷� ����Ǹ� ����
	static double b = 3.14;
	static String name = "ȫ�浿";

	int c = 200; // �ν��Ͻ� ����, �������� new->����, �ش� Ŭ������ ����� ���x
	double d = 5.5;
	String addr = "�ϳ���";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(a + " " + b + " " + name);
		StaticEx02 st02 = new StaticEx02();
		System.out.println(st02.c + " " + st02.d + " " + st02.addr); // �޸𸮿� �÷��� ���� �ʴ� �ʵ�
	}

}
