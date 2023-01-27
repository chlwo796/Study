package javaMId2.ex01;

public class Animal {
	private String food;
	private String sound;

	public void printAll() {
		System.out.println("먹는 것은 " + food);
		System.out.println("소리는? " + sound);
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
	
	public void A() {	// 자식에게 Override되어있어 부모에 같은이름의 메소드를 추가해줌
		
	}
	
//	public final void A() {	// final 처리된 method 사용 확인 -> Dog class 확인
//		
//	}

}
