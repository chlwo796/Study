package javaMid10.ex08;

//import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
//		FileWriter fw;
//		try {
//			fw = new FileWriter("file.txt");
//			fw.write("Java");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			fw.close();
//		}
		try (FileWriter fw = new FileWriter("file.txt")) {
			fw.write("java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
