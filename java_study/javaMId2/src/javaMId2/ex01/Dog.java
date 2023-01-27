package javaMId2.ex01;

public final class Dog extends Animal {	// final 처리된 class 확인 -> Puppy class 확인
	private String character; // 특징

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

//	부모와 메소드명, 리턴타입이 같지만 데이터값이 다름
//	@ annotation = 기능이 있는 주석, Override = 부모에게도 있는 메소드, 한메소드만
	@Override
	public void printAll() {
		System.out.println("음식은? " + getFood());
		System.out.println("소리는? " + getSound());
		System.out.println("특징은? " + getCharacter());
	}

	@Override // Override = 재정의
	public void A() { // 부모에 같은 이름이 없으면 에러

	}
//	public void A() {	// 부모에게 final 로 처리된 method에는 Overriding 불가
//		
//	}
}
