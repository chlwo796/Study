package javaBasic5.ex19;

public class Account {
	private int balance; // 0<=balance<=1000000

	private static final int MIN_BALANCE = 0;
	private static final int MAX_BALANCE = 1000000;
	private String account;
	private String name;
	private int money;

	public int getBalance() {
		return balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {

			this.balance = balance;
		} else { // else ´Â return ¾ÈÇÔ

		}
	}
}
