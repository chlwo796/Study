package javaBasic5.day01;

import javaBasic5.day01.dao.BookDao;

public class ClassEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01.a(); // static method ȣ��
		Ex01 ex01 = new Ex01(); // instance method�� ȣ���ϴ� ���
		ex01.b(); // ����������.�޼ҵ��();

//		��Ű������� = ���������
//		�ٸ���Ű�� �ȿ� �ִ� Ŭ���� ����Ѵ�. is a, �������� �����̴�. ->��Ӱ��� extends, implements
//		has a ~�� ������ �ִ�. �ڵ����� �ڵ��� ������ �ִ�.(��ǰ) -> ���հ��� import

		BookDao bookdao = new BookDao(); // ������Ű��, ���հ��� import
//		bookdao.name = "ȫ�浿";	// private�� �����͸� ����(��������), ĸ��ȭ
		bookdao.setName("ȫ�浿"); // public���� ������ �޼ҵ忡 ���� �־��ش�

//		���������� = public, protected, default(package), private
//		�̱��� = ��¥�����͸� import�� ��, �ٸ� class���� �Ź� ��üȭ �Ͽ� ���������� ���� �ʿ䰡 ����.
	}
}

class Ex01 {

	static int k = 100;
	int s = 200;

	static void a() {
		k = k + 200;
//		s = s+k; // instance������ �ν��Ͻ�ȭ �ؾ� ��밡��
	}

	void b() {
		k = k + 100; // instance method���� static ������ ��� ����
		s = s + 100;
	}
}