package javaChap12.example01;

public class EqualsExample {
	public static void main(String[] args) {
		Member member1 = new Member("1");
		Member member2 = new Member("1");
		Member member3 = new Member("3");

		if (member1.equals(member2)) {
			System.out.println("1�� 2�� ����");
		} else {
			System.out.println("1�� 2�� �ٸ�");
		}
		if (member1.equals(member3)) {
			System.out.println("1�� 3�� ����");
		} else {
			System.out.println("1�� 3�� �ٸ�");
		}
	}
}