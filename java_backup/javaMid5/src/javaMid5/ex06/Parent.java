package javaMid5.ex06;

public class Parent {
//	chap06. ex06
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

//	chap06.ex07
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
