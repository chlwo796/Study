package ch02.sec03;

import java.util.Scanner;

public class CharExample {

	public static void main(String[] args) {
		//문자 한글자 'a' 컴퓨터 사용하는 전 세계문자는 유니코드라 명시해둠
		char aWord = 'a'; //a의 유니코드 = 97
		System.out.println((char)(aWord - 32)); //(char) = data type char로 강제
		
		char bWord = 'K';
		System.out.println( (char) (bWord + 40)); //문자 K를 s로 출력하기
		
		char name1 = '최';
		char name2 = '재';
		char name3 = '환'; //컴퓨터에서 처리되는 문자는 유니코드로 처리된다.
		
		System.out.println((int) (name1) + " " + (int) name2 + " " + (int) (name3));
		
		//여러글자 문자열 " " 문자열 객체 String을 사용한다
		String name = "최재환"; //한글 1글자 = 3byte 2글자 = 6byte ...
		
		String hakbun = "221208"; 
		
		int hakbun1 = 221208;   //문자열을 정수형으로 바꾼다.
		//위의 학번의 다음사람의 학번을 구하시오 답 = 221209
		
		System.out.println("다음 사람의 학번은 " + (hakbun1 + 1));
		
		System.out.println(Integer.MAX_VALUE); //정수의 최대값.
		System.out.println(Integer.BYTES);//정수는 4byte이다.
		System.out.println(Integer.SIZE); // 1byte = 8bit
		System.out.println(Integer.valueOf(hakbun)+1);
		
		String avgS = "52.2"; // 52.2 + 100 = 152.2
		// 문자열은 계산이 안되니 문자열을 실수형으로 바꿔야 한다.
		// 100을 더해 출력한다. double도 실수형
		System.out.println(Double.valueOf(avgS)+100);
		float convAvg = Float.parseFloat(avgS); //"52.2" --> 52.2
		convAvg = convAvg + 100;
		System.out.println(convAvg);
		
		String sex = "false"; //"true" --> true
		//문자열 "true"를 불린형(논리)로 변환하세요
		boolean conSex = Boolean.parseBoolean(sex);
		//boolean conSex = Boolean.valueOf(sex);
		//parse = 바뀐다.
		System.out.println(conSex);
		if (conSex)
			System.out.println("남자"); //true면 남자
		else
			System.out.println("여자"); //false면 여자
		
		//자동타입변환
		byte v1 = 10; //1byte
		int v2 = 20; //4byte
		
		v2 = v1; // v1이 v2자리로 들어간다. v2 = 10 byte형의 값이 int형으로 들어간다. 큰 곳으로 이동하니 오류 없음.
		
		//강제형 변환
		v1 =(byte) v2; //v2의 값을 v1에 넣는다. 즉 int형이 byte형으로 들어간다. 큰 값이 작은 값으로 들어감.
		
		int v3 = 50;
		double v4 = 10.0; //8byte 소수점이하 32자리까지 표기
		float v5 = 20.5f; //4byte, 소수점이하 8자리까지 표기, float type에는 숫자 뒤에 f를 붙힌다.
		
		v4 = v3;  //실수형이 정수형 보다 큰 범위.
		v4 = v5;
		v3 = (int) v4;
		v3 = (int) v5;
		v5 = (float) v4;
		
		//형 변환 매우 중요!!
		
		//문제 숫자2개를 입력받아서 사칙연산 해보세요
		Scanner sc = new Scanner(System.in); //키보드 입력을 담당하는 Scanner 클래스를 사용한다.
		
		/*int x = sc.nextInt(); //키보드에서 정수를 입력받는다.
		System.out.println("입력값" + x);
		
		int y = sc.nextInt();
		System.out.println("입력값" + y);*/
		
		//double형으로 실수 2개를 입력받으세요
		
		/*double c = sc.nextDouble();
		double d = sc.nextDouble();
		System.out.println("실수입력값" + c);
		System.out.println("실수입력값" + d);*/
		
		/*boolean x = sc.nextBoolean();
		boolean y = sc.nextBoolean();*/
		
		String c = sc.nextLine(); //공백있는 출력값을 원하면 nextLine
		System.out.println(c);
		String d = sc.next(); //공백없음
		System.out.println(d);
	}

}
