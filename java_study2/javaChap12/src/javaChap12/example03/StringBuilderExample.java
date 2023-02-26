package javaChap12.example03;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder data = new StringBuilder();
		data.append("DEF");
		data.insert(0, "ABC");
		data.delete(3, 4);
		System.out.println(data);
		data.toString();
		
		System.out.println(data);
	}
}
