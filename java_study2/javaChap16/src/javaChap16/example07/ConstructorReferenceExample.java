package javaChap16.example07;

public class ConstructorReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		Member member1 = person.getMember1(id -> new Member(id));
		// ������ ����ǥ��
		member1 = person.getMember1(Member::new);
		System.out.println(member1);

		Member member2 = person.getMember2((id, name) -> new Member(id, name));
		// ������ ����ǥ��, getMember2�� �߻�޼ҵ��� �Ű������� ���� �´� �����ڸ� ã�� �����Ѵ�. ������ ������ ����
		member2 = person.getMember2(Member::new);
		System.out.println(member2);
	}
}
