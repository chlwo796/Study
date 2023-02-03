package javaMid4.ex09;

public class SoundableMain {

//	chap08.ex06
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSound(new Cat());
		printSound(new Dog());
	}

	private static void printSound(Soundable soundable) {
		// TODO Auto-generated method stub
		System.out.println(soundable.sound());
	}

}
