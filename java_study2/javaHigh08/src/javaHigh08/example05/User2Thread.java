package javaHigh08.example05;

public class User2Thread extends Thread {
	private Calculator calculator;

	public User2Thread() {
		// Thread의 이름을 넣어줌
		setName("User2Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
//		calculator.setMemory1(50);
		calculator.setMemory2(50);
	}

}
