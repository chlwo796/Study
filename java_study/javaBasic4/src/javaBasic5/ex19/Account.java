package javaBasic5.ex19;

import java.util.Scanner;

public class Account {

	Scanner sc = new Scanner(System.in);
	private int balance; // 0<=balance<=1000000

//	private static final int MIN_BALANCE = 0;
//	private static final int MAX_BALANCE = 1000000;
	private String account;
	private String name;
	private int money;
	Account[] newArray;

	public Account[] getNewArray() {
		return newArray;
	}

	public void setNewArray(Account[] newArray) {
		this.newArray = newArray;
	}

//	public void input() {
//		Account[] newArray = new Account[3];
//
//		System.out.println("계좌번호 : ");
//		setAccount(sc.nextLine());
//		System.out.println("계좌주 :");
//		setName(sc.nextLine());
//		System.out.println("초기입금액 : ");
//		setBalance(sc.nextLine());
//		System.out.println("결과 : 계좌가 생성되었습니다.");
//
//		newArray[0] = getAccount();
//		newArray[1] = getName();
//		newArray[2] = getBalance();
//
//		setNewArray(newArray);
////		for(int i = 0;i<accountArray.length;i++) {
////			if(accountArray[i] == null) {
////				accountArray = newArray;
////			}else break;
//	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

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

//	public void setBalance(int balance) {
//		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
//
//			this.balance = balance;
//		} else { // else 는 return 안함
//
//		}
}
