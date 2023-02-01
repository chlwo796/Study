package javaMid3.ex04;

public class Tank extends Unit {
	void changeMode() {
		System.out.println("공격모드를 변환한다.");
	}

	@Override
	void move(int x, int y) {
		super.x = x-50;
		super.y = y+50;
		System.out.println("탱크 현재 위치 : (" + super.x + ", " + super.y + ")");
	}

	@Override
	void stop() {
		System.out.println("탱크의 현재 위치에서 정지");
	}
}
