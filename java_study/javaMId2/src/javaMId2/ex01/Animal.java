package javaMId2.ex01;

public class Animal {
	private String food;
	private String sound;

	public void printAll() {
		System.out.println("�Դ� ���� " + food);
		System.out.println("�Ҹ���? " + sound);
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
	
	public void A() {	// �ڽĿ��� Override�Ǿ��־� �θ� �����̸��� �޼ҵ带 �߰�����
		
	}
	
//	public final void A() {	// final ó���� method ��� Ȯ�� -> Dog class Ȯ��
//		
//	}

}
