package javaMid3.ex04;

public class Dropship extends Unit {

	@Override
	void move(int x, int y) {
		super.x = x - 100;
		super.y = y - 500;
	}

	@Override
	void stop() {
		System.out.println("수송선의 현재 위치에서 정지");
	}

//	void load(int x, int y) {
//		
//		System.out.println("수송선 보병위치 (" + x + ", " + y + ")에서 보병을 태운다.");
//	}

//	void unload(int x, int y) {
//		System.out.println("수송선 탱크위치 (" + x + ", " + y + ")에서 탱크를 내린다.");
//	}
	void load(Marine marine) {
		System.out.println("수송선 보병위치 (" + marine.getX() + ", " + marine.getY() + ")에서 보병을 태운다.");
	}
	void unload(Tank tank) {
		System.out.println("수송선 탱크위치 (" + tank.getX() + ", " + tank.getY() + ")에서 탱크를 내린다.");
	}
	
//	다른 참조값을 가져오고 싶을때는 Main에서 직접 주소값(000.get00())을 주어도 좋지만,
//	미리 main method에서 인스턴스화한 객체들 메소드 호출할 때 주고,
//	해당 클래서에서 여러가지변수를 자유롭게 사용하는것도 좋다.
}
