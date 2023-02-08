package javaMid9.ex08;

public class Account {
	private long balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance+=money;
	}
	public void withdraw(int money) throws InsufficientException{
		if(balance<money) {
			throw new InsufficientException("�ܰ� ����" + (money-balance) + "���ڶ�");
		}
		balance -= money;
	}
}
