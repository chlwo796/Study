package javaMid3.ex04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Unit unit = new Unit();
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();

		Scanner sc = new Scanner(System.in);

		System.out.println("������ ��ġ");

		marine.setX(sc.nextInt());
		marine.setY(sc.nextInt());

		marine.move(marine.getX(), marine.getY());
//		System.out.println(marine.getX() + " " + marine.getY());
		marine.stimPack();
		
		System.out.println("��ũ�� ��ġ");
		tank.setX(sc.nextInt());
		tank.setY(sc.nextInt());
		
		tank.move(tank.getX(), tank.getY());
		tank.stop();
		tank.changeMode();
		
		System.out.println("���ۼ��� ��ġ");
		dropship.setX(sc.nextInt());
		dropship.setY(sc.nextInt());
		
		dropship.move(dropship.getX(), dropship.getY());
		dropship.stop();
		dropship.load(marine);
		dropship.unload(tank);

	}

}
