package interfaceEx1;

public class Fighter extends Unit implements Fightable{
	public Fighter(int currentHP) {
		super(currentHP);
		System.out.println("������ġ : " + x + ", y : " + y);
		System.out.println("����ü�� : " + currentHP);
	}
	
@Override
public void attack(Unit unit) {
	currentHP = currentHP-5;
}
@Override
	public void move(int x, int y) {
		super.x = x;
		super.y = y;
	}
}
