package interfaceEx1;

public class Fighter extends Unit implements Fightable{
	public Fighter(int currentHP) {
		super(currentHP);
		System.out.println("현재위치 : " + x + ", y : " + y);
		System.out.println("현재체력 : " + currentHP);
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
