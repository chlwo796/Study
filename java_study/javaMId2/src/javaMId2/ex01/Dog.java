package javaMId2.ex01;

public final class Dog extends Animal {	// final ó���� class Ȯ�� -> Puppy class Ȯ��
	private String character; // Ư¡

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

//	�θ�� �޼ҵ��, ����Ÿ���� ������ �����Ͱ��� �ٸ�
//	@ annotation = ����� �ִ� �ּ�, Override = �θ𿡰Ե� �ִ� �޼ҵ�, �Ѹ޼ҵ常
	@Override
	public void printAll() {
		System.out.println("������? " + getFood());
		System.out.println("�Ҹ���? " + getSound());
		System.out.println("Ư¡��? " + getCharacter());
	}

	@Override // Override = ������
	public void A() { // �θ� ���� �̸��� ������ ����

	}
//	public void A() {	// �θ𿡰� final �� ó���� method���� Overriding �Ұ�
//		
//	}
}
