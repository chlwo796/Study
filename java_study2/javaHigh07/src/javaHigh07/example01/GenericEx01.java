package javaHigh07.example01;

public class GenericEx01 {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.content = "사과";
//		box1.content = 100;	// Box<String> 이므로 에러발생
		
		Box<Integer> box2 = new Box<Integer>();
		box2.content = 100;
//		box2.content = "사과"; // Box<Integer> 이므로 에러 발생
	}
}
class Box<T>{
	public T content;
}
