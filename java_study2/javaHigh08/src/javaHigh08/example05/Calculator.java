package javaHigh08.example05;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public void setMemory1(int memory) {
		synchronized (this) {
			this.memory = memory;

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);

		}
	}

	public synchronized void setMemory2(int memory) {

		this.memory = memory;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}