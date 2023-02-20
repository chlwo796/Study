package javaHigh05.example07;

import java.util.Iterator;
import java.util.Stack;

public class StackEx02 {
	public static void main(String[] args) {
		Stack<Car> stack = new Stack<Car>();
		stack.push(new Car("K5"));
		stack.push(new Car("티코"));
		stack.push(new Car("그랜저"));
		stack.push(new Car("벤츠"));
		stack.push(new Car("소나타"));
		
		Iterator<Car> iterator = stack.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(stack.pop().getCarName());
		}
	}
}