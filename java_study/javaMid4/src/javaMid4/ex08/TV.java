package javaMid4.ex08;

public class TV implements Remocon {
//	chap08.ex05
	@Override
	public void powerOn() {
		System.out.println("TV¸¦ Ä×½À´Ï´Ù.");

	}

	public static void main(String[] args) {
		Remocon r = new TV();
		r.powerOn();
	}

}
