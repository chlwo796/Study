package javaChap07.exercise06;

public class Child extends Parent {
	public int studentNo;

	public Child(String name, int studentNo) {
		// �ڽİ�ü�� �����ڴ� super();�� ��õǾ� ���������� �θ��� �⺻�����ڸ� ȣ���Ѵ�.
		// 1. �θ��� �⺻������ �߰�
		// 2. �ڽĻ����ڿ� super(); �߰�
		// super(name);
		this.name = name;
		this.studentNo = studentNo;
	}
}