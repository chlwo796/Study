package javaMid5.ex06;

public class Parent {
//	����6��
//	public String name;
//
//	public Parent(String name) {
//		this.name = name;
////		�� �����ڰ� �ֱ� ������ �⺻�����ڰ� ������ �ʴ´�.
//	}
//
//	public Parent() {
////		�θ��� �⺻�����ڸ� ����� ���Ƶ� ���� ���� ����
//	}

//	����7��
	public String nation;

	public Parent() {
		this("���ѹα�");
		System.out.println("Parent() call");

	}

	public Parent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
