package javaMid9.ex08;

public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(10000);
		System.out.println("잔금은 " + account.getBalance());
		
		try {
			int money = 15000;
			account.withdraw(money);
			System.out.println("출금액은 " + money + "입니다.");
			System.out.println("잔금은 " + account.getBalance());
		} catch (InsufficientException e) {
			// TODO Auto-generated catch block
			String message = e.getMessage();
			System.out.println(message);
		}
		
	}
}
