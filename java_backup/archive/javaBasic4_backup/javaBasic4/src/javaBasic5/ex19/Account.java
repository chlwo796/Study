package javaBasic5.ex19;

public class Account {
	private int balance; // 0<=balance<=1000000

	private static final int MIN_BALANCE = 0;
	private static final int MAX_BALANCE = 1000000;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {

			this.balance = balance;
		} else { // else ´Â return ¾ÈÇÔ

		}
	}
}
