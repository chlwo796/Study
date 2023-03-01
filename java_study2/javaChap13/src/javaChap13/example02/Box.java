package javaChap13.example02;

public class Box<T> {
	public T content;

	public boolean compare(Box<T> box) {
		boolean result = this.content.equals(box.content);
		return result;
	}
}
