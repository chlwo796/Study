package interfaceEx1;

public class Main {
	public static void main(String[] args) {
		Fighter fighter = new Fighter(100);

//		if (fighter instanceof Unit) {
//			System.out.println("Unit�� �ڼ�");
//		}
//		if (fighter instanceof Fightable) {
//			System.out.println("Fightable�� ����");
//		}
//		if (fighter instanceof Movable) {
//			System.out.println("Movable�� ����");
//		}
//		if (fighter instanceof Attackable) {
//			System.out.println("Attackable�� ����");
//		}
//		if (fighter instanceof Object) {
//			System.out.println("object�� �ڼ�");
//		}
		fighter.move(2, 3);
		System.out.println("�̵� �� ������ġ x : " + fighter.x + ", y : " + fighter.y);
		System.out.println("�̉� �� ����ü��" + fighter.currentHP);
		fighter.attack(fighter);
		System.out.println("���� �� ������ġ" + fighter.x + ", y : " + fighter.y);
		System.out.println("���� �� ����ü��" + fighter.currentHP);
	}
}