package javaMid5.ex06;

public class Child extends Parent {
//	chap06. ex06
//	public int studentNo;
//
//	public Child(String name, int studentNo) {
////		super(name);	// �ڽ� �����ڿ��� �θ��� �����ڸ� ȣ���ϴ� ��
////		���� ��, super(name, studentNo)�� �ڵ����� ������
//		
////		super�� ȣ������ �ʾƵ�, �θ�Ŭ������ �⺻�����ڰ� �ִٸ� �����ذᰡ��.
////		�θ� �⺻�����ڸ� �⺻���� �־��ش�. 
////		�ڽ� ��ü������ ���߿� ���� �߻��� ���� �� �ִ�.
//		this.name = name;
//		this.studentNo = studentNo;
//	}
//	����
//	1. �θ� �⺻�����ڸ� ������ش�.
//	2. �ڽĻ����ڿ� super(name);�� ����صд�.
//	3. �θ� �����ڸ� ��� �����ش�.

//	chap06.ex07
	public String name;

	public Child() {
		this("ȫ�浿");
		System.out.println("Child() call");
	}

	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
