package javaMid3.ex04;

public class Dropship extends Unit {

	@Override
	void move(int x, int y) {
		super.x = x - 100;
		super.y = y - 500;
	}

	@Override
	void stop() {
		System.out.println("���ۼ��� ���� ��ġ���� ����");
	}

//	void load(int x, int y) {
//		
//		System.out.println("���ۼ� ������ġ (" + x + ", " + y + ")���� ������ �¿��.");
//	}

//	void unload(int x, int y) {
//		System.out.println("���ۼ� ��ũ��ġ (" + x + ", " + y + ")���� ��ũ�� ������.");
//	}
	void load(Marine marine) {
		System.out.println("���ۼ� ������ġ (" + marine.getX() + ", " + marine.getY() + ")���� ������ �¿��.");
	}
	void unload(Tank tank) {
		System.out.println("���ۼ� ��ũ��ġ (" + tank.getX() + ", " + tank.getY() + ")���� ��ũ�� ������.");
	}
	
//	�ٸ� �������� �������� �������� Main���� ���� �ּҰ�(000.get00())�� �־ ������,
//	�̸� main method���� �ν��Ͻ�ȭ�� ��ü�� �޼ҵ� ȣ���� �� �ְ�,
//	�ش� Ŭ�������� �������������� �����Ӱ� ����ϴ°͵� ����.
}
