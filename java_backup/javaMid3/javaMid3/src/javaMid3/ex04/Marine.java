package javaMid3.ex04;

public class Marine extends Unit{
	
	@Override
	void move(int x, int y) {
//		a = 10;
//		super.move(x, y);	// 부모의 메소드를 호출을 먼저한다.
//		System.out.println("보병의 위치 : " + "(" + (x+a) + ", " + (y-a) + ")");
		
		super.x = x + 10; // 부모의 x에 받은 x값에 10을 더해서 준다.
		super.y = y - 10;
//		this.x = x + 10; // 자기 클래스에 선언된 해당변수가 없으면 this는 부모클래스의 변수로 받는다.
		System.out.println("보명 현재 위치 : (" + super.x + ", " + super.y + ")");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("보병 현재 위치에서 정지");
	}

	void stimPack() {
		System.out.println("보병 스팀팩을 사용한다.");
	}
}
