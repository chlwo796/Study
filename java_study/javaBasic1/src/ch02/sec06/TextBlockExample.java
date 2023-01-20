package ch02.sec06;

public class TextBlockExample {

	public static void main(String[] args) {
		// java 14부터 제공되는 기능. 주석같이 블록안에 있는 문자를 전부 문자열로 받아들인다.
		// String block = """~~~\n\n\t~~~~~~~\n\n""";
		String block = "~~~\n\n\t~~~~~~~\n\n";
		
		System.out.println(block);
				
	}

}
