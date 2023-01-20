package ch02.sec04;

public class FloatDoubleExample {
	
	public static void main(String[] args) {
		// Float, Double = 실수타입
		float a = 0.1234567890123456789f;		// float 타입에는 뒤에 'f'를 입력한다.
		double b = 0.1234567890123456789;
		
		System.out.println(a);
		System.out.println(b);		// 출력값에서 차이 확인 가능, double 타입이 float 타입보다 약 2배의 유효자리수를 가진다.
		
		// e, E = 10의 거듭제곱 Literal
		float c = 6e4f;		//6*10*10*10*10
		double d = 6e4;
		double e = 5e-2;	//5*0.1*0.1
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}

}
