package javaHigh09.example04;

public class ConstructorReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		// 익명구현객체 표현
		Member m1 = person.getMember1(new Createable1() {

			@Override
			public Member create(String id) {
				// TODO Auto-generated method stub
				return new Member(id);
			}
		});
		// 람다식 표현
		m1 = person.getMember1((String id) -> {
			return new Member(id);
		});

		m1 = person.getMember1(id -> new Member(id));

		// 매개변수 생성자참조 = 람다식에서 결과를 리턴하는 것이 객체를 생성하는 것 밖에 없다면 사용 가능

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