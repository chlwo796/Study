package javaHigh09.example04;

public class ConstructorReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		// �͸�����ü ǥ��
		Member m1 = person.getMember1(new Createable1() {

			@Override
			public Member create(String id) {
				// TODO Auto-generated method stub
				return new Member(id);
			}
		});
		// ���ٽ� ǥ��
		m1 = person.getMember1((String id) -> {
			return new Member(id);
		});

		m1 = person.getMember1(id -> new Member(id));

		// �Ű����� ���������� = ���ٽĿ��� ����� �����ϴ� ���� ��ü�� �����ϴ� �� �ۿ� ���ٸ� ��� ����

		m1 = person.getMember1(Member::new);
		System.out.println(m1);
		System.out.println();

		Member m2 = person.getMember2(new Createable2() {

			@Override
			public Member create(String id, String name) {
				// TODO Auto-generated method stub
				return new Member(id, name);
			}
		});
		m2 = person.getMember2((String id, String name) -> {
			return new Member(id, name);
		});
		m2 = person.getMember2((id, name) -> new Member(id, name));
		
		m2 = person.getMember2(Member :: new);
		System.out.println(m2);
	}
}