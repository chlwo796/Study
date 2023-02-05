package tempMemo2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter fighter = new Fighter();
		Fightable fightable = new Fighter();
		
		
		if (fighter instanceof Unit) {
			System.out.println("Unit의 자손");
		}
		if (fighter instanceof Fightable) {
			System.out.println("Fightable을 구현");
		}
		if (fighter instanceof Movable) {
			System.out.println("Movable을 구현");
		}
		if (fighter instanceof Attackable) {
			System.out.println("Attackable을 구현");
		}
		if (fighter instanceof Object) {
			System.out.println("object의 자손");
		}

	}
	void attack1(Fightable fightable) {
		
	}
	Fightable method1() {
		Fightable fightable = new Fighter();
		return fightable;
	}

}
