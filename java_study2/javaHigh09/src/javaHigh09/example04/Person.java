package javaHigh09.example04;

public class Person {
	public Member getMember1(Createable1 createable) {
		// 매개변수 = 인터페이스
		String id = "winter";
		Member member = createable.create(id);	// 구현
		return member;
	}

	public Member getMember2(Createable2 createable) {
		String id = "winter";
		String name = "한겨울";
		Member member = createable.create(id, name);
		return member;
	}
}
