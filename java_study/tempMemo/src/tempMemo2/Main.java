package tempMemo2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter fighter = new Fighter();
		Fightable fightable = new Fighter();
		
		
		if (fighter instanceof Unit) {
			System.out.println("Unit�� �ڼ�");
		}
		if (fighter instanceof Fightable) {
			System.out.println("Fightable�� ����");
		}
		if (fighter instanceof Movable) {
			System.out.println("Movable�� ����");
		}
		if (fighter instanceof Attackable) {
			System.out.println("Attackable�� ����");
		}
		if (fighter instanceof Object) {
			System.out.println("object�� �ڼ�");
		}

	}
	void attack1(Fightable fightable) {
		
	}
	Fightable method1() {
		Fightable fightable = new Fighter();
		return fightable;
	}

}
