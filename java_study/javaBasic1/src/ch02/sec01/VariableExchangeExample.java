package ch02.sec01;

public class VariableExchangeExample {

	public static void main(String[] args) {
		
		int x = 3;
		int y = 5;
		swap(x, y); //x = 3, y = 5 라는 value 를 가지고 아래 swap method 호출
		
		System.out.println("x:" + x + ", y:" + y);
		
		int bkor = 0b1011;
		
		System.out.println(bkor);
	}//end main()
	
	static void swap(int x,int y) {//x = 3, y = 5 라는 value를 받음
		int temp = y; // temp라는 새로운 변수 선언.
		y = x;
		x = temp;
		
		System.out.println("x:" + x + ", y:" + y + " 이 곳은 swap method");
		
		/*
		byte kor = 100;		// 1byte = 8bit, bit는 0과 1이 저장되는 단위
		short eng = 85;		// 2byte = 16bit
		char asd = "재환";	// 2byte, 문자를 담는 변수형이지만, 실체는 정수형. 아스키코드.
		int mat = 90;		// 4byte = 32bit, 가장 많이 쓰는 정수타입.
		long sci = 86;		// 8byte = 64bit
		byte kor1 = 89;
		
		int total = kor + kor1; //1byte + 1byte = 1byte 사칙연산의 부호는 4byte를 차지한다.
		*/

	}

}//end class

//좋은 코드