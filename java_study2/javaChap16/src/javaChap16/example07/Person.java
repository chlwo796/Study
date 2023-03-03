package javaChap16.example07;

public class Person {
	public Member getMember1(Creatable1 creatable1) {
		String id = "Winter";
		Member member = creatable1.create(id);
		return member;
	}

	public Member getMember2(Creatable2 creatable2) {
		String id = "Winter";
		String name = "ÇÑ°Ü¿ï";
		Member member = creatable2.create(id, name);
		return member;
	}
}
