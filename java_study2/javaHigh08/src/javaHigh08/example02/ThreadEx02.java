package javaHigh08.example02;

public class ThreadEx02 {
	public static void main(String[] args) {
		Chicken chicken = new Chicken();
		chicken.start();
		Chicken fruit = new Fruit();
		fruit.start();

		Thread thread1 = new Thread(new Kimchi());
		Thread thread2 = new Thread(new Pizza());
		thread1.start();
		thread2.start();
	}
}