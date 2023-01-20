package ch05.sec05;

public class SubStringExample {

	public static void main(String[] args) {
//		잘라내기 = .substring();
//		.substring(int beginindex) = beginindex에서 끝까지 잘라내기
//		.substring(int beginindex, int endindex) = beginindex에서 endindex 앞까지 잘라내기
		
		String number = "930122-1209218";
		String firstNumber = number.substring(0,6);	// 0부터 6 앞까지,0~5 6자리
		String secondNumber = number.substring(7);	// 7자리부터 끝까지
		
		System.out.println(firstNumber);
		System.out.println(secondNumber);
		
	}

}
