package javaMid4.ex08;

public class TV implements Remocon {
//	chap08.ex05
	@Override
	public void powerOn() {
		System.out.println("TV�� �׽��ϴ�.");

	}

	public static void main(String[] args) {
		Remocon r = new TV();
		r.powerOn();
	}

}
