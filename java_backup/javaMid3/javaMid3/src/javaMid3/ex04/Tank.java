package javaMid3.ex04;

public class Tank extends Unit {
	void changeMode() {
		System.out.println("���ݸ�带 ��ȯ�Ѵ�.");
	}

	@Override
	void move(int x, int y) {
		super.x = x-50;
		super.y = y+50;
		System.out.println("��ũ ���� ��ġ : (" + super.x + ", " + super.y + ")");
	}

	@Override
	void stop() {
		System.out.println("��ũ�� ���� ��ġ���� ����");
	}
}
