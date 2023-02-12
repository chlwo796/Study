package javaMid11.example07;

public class ThrowsExample02 {
	public static void main(String[] args) throws Exception {

		findClass();
	}

	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
