package javaHigh09.example04;

public class Person {
	public Member getMember1(Createable1 createable) {
		// �Ű����� = �������̽�
		String id = "winter";
		Member member = createable.create(id);	// ����
		return member;
	}

	public Member getMember2(Createable2 createable) {
		String id = "winter";
		String name = "�Ѱܿ�";
		Member member = createable.create(id, name);
		return member;
	}
}
