package javaMid10.ex06;

public class Excercises06 {
	public static void main(String[] args) {
		String[] strArray = { "10", "20a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스초과");
			} catch (NumberFormatException e) {
				System.out.println("숫자변환오류");
			} finally {
				System.out.println(value);
			}
		}
	}
}
