package javaMid1.ch07;

public class ExtendsEx01 {

	public static void main(String[] args) {
//		���
//		A extends P
		A a = new A(); // �ڽ�Ŭ������ ��üȭ�Ǹ� �θ�Ŭ������ �����͵� ����� �� �ִ�.

		a.setName("����ȯ");
		a.setPhone("01041160586");

		System.out.println(a.getName());
		System.out.println(a.getPhone());
//		System.out.println(a.printM()); a.printM()�� returnŸ���� ���� data input�� �� �� ����.
		a.printM(); // method ��ü�� ȣ�����ش�.

//		B extends P
		B b = new B();
		b.setAge(30);
		b.setPhone("0104238238");

		System.out.println(b.getAge());
		System.out.println(b.getPhone());

//		C field school ������б�, �̸�, ��ȣ ���� ���� ���
//		C->B->A->P ��Ӱ��� = CŬ���������� B,A,P ������ ��� ��� ����
		C c = new C();
		
		c.setSchool("������б�");
		c.setAge(30);
		c.setName("����ȯ");
		c.setPhone("01041150505");

		c.printAll();
	}
}