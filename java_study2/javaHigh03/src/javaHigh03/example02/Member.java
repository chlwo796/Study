package javaHigh03.example02;

public class Member {

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	// �̸��� ���� ���̰� ������ �������(���ü)��� ���� ���α׷����� �ۼ��ϱ�
	// 1. hashcode() 2. equals()
	// hashCode()����� equals()������ ������ �޼ҵ� ȣ������ �ʾƵ� Set ��ü�� �ڵ�ȣ���Ѵ�.
	@Override
	public int hashCode() {
		// �����ڰ� hashCode()�� ������
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
//		obj �������� 2��°�� set �ȿ� �� �ڷ��� �ּҰ� ����ִ�.
//		target.name = �� �ڷ��� �̸�, this.name = ����ִ� �ڷ��� �̸�
		if(obj instanceof Member) {
			Member target = (Member) obj;
			return target.name.equals(this.name) && target.age == this.age;
		}
		return false;
	}
}