package interfaceEx1;

public class Main {
	public static void main(String[] args) {
		Fighter fighter = new Fighter(100);

//		if (fighter instanceof Unit) {
//			System.out.println("Unit의 자손");
//		}
//		if (fighter instanceof Fightable) {
//			System.out.println("Fightable을 구현");
//		}
//		if (fighter instanceof Movable) {
//			System.out.println("Movable을 구현");
//		}
//		if (fighter instanceof Attackable) {
//			System.out.println("Attackable을 구현");
//		}
//		if (fighter instanceof Object) {
//			System.out.println("object의 자손");
//		}
		fighter.move(2, 3);
		System.out.println("이동 후 현재위치 x : " + fighter.x + ", y : " + fighter.y);
		System.out.println("이돟 후 현재체력" + fighter.currentHP);
		fighter.attack(fighter);
		System.out.println("공격 후 현재위치" + fighter.x + ", y : " + fighter.y);
		System.out.println("공격 후 현재체력" + fighter.currentHP);
	}
}