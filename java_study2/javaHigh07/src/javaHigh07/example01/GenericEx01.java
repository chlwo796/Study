package javaHigh07.example01;

public class GenericEx01 {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.content = "���";
//		box1.content = 100;	// Box<String> �̹Ƿ� �����߻�
		
		Box<Integer> box2 = new Box<Integer>();
		box2.content = 100;
//		box2.content = "���"; // Box<Integer> �̹Ƿ� ���� �߻�
	}
}
class Box<T>{
	public T content;
}
