package javaMid4.ex07;

public class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("�ý�");
	}

	@Override
	public void money() {
		System.out.println(3850);
	}
}