package javaMid3.ex04;

public class Marine extends Unit{
	
	@Override
	void move(int x, int y) {
//		a = 10;
//		super.move(x, y);	// �θ��� �޼ҵ带 ȣ���� �����Ѵ�.
//		System.out.println("������ ��ġ : " + "(" + (x+a) + ", " + (y-a) + ")");
		
		super.x = x + 10; // �θ��� x�� ���� x���� 10�� ���ؼ� �ش�.
		super.y = y - 10;
//		this.x = x + 10; // �ڱ� Ŭ������ ����� �ش纯���� ������ this�� �θ�Ŭ������ ������ �޴´�.
		System.out.println("���� ���� ��ġ : (" + super.x + ", " + super.y + ")");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("���� ���� ��ġ���� ����");
	}

	void stimPack() {
		System.out.println("���� �������� ����Ѵ�.");
	}
}
