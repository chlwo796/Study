package javaHigh05.example07;

import java.util.Stack;

public class StackEx01 {
	public static void main(String[] args) {
		Stack<Coin> stack1 = new Stack<Coin>();
		
		stack1.push(new Coin(100));
		stack1.push(new Coin(50));
		stack1.push(new Coin(500));
		stack1.push(new Coin(10));
		
		while(!stack1.isEmpty()) {
			Coin coin = stack1.pop();
			System.out.println(coin.getValue());
		}
	}
}
