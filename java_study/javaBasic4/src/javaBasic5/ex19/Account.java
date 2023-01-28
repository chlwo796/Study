package javaBasic5.ex19;

public class Account{

	private int balance; // 0<=balance<=1000000

	protected static final int MIN_BALANCE = 0;
	protected static final int MAX_BALANCE = 1000000;
	private String account;
	private String name;
	
	int check = 0;
	
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

	public void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}

	}
}
