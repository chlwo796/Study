package ch05.sec10;

public class AdvancedForExample {

	public static void main(String[] args) {
//		Çâ»óµÈ for
		
		int[] intArray = {29,291,293,12,55};
		
		int sum = 0;
		
		for(int score : intArray) {
			sum = sum + score;
		}
		System.out.println(sum);
		
		double ave = (double)(sum/intArray.length);
		System.out.println(ave);
	}

}
