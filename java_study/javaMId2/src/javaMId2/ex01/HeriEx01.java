package javaMId2.ex01;

public class HeriEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal animal = new Animal();

		animal.setFood("¸Ô´Â °Í");
		animal.setSound("¼Ò¸®");
		animal.printAll();

		Dog dog = new Dog();

		dog.setFood("»ç·á");
		dog.setSound("¸Û¸Û");
		dog.setCharacter("½Ã²ô·¯¿ò");
		dog.printAll();
	}

}
