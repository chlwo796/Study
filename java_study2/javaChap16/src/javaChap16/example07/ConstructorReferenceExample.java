package javaChap16.example07;

public class ConstructorReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		Member member1 = person.getMember1(id -> new Member(id));
		// 생성자 참조표현
		member1 = person.getMember1(Member::new);
		System.out.println(member1);

		Member member2 = person.getMember2((id, name) -> new Member(id, name));
		// 생성자 참조표현, getMember2의 추상메소드의 매개변수에 따라 맞는 생성자를 찾아 생성한다. 없으면 컴파일 오류
		member2 = person.getMember2(Member::new);
		System.out.println(member2);
	}
}
