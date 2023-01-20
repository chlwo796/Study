package javaBasic1;

public class VarEx{

	public static void main(String[] args) { //main : 메인메소드
		// TODO Auto-generated method stub  //주석, 설명문
		System.out.println("여러글자");
		System.out.println('글');
		
		int a; //변수를 자료형으로 선언한다.
		
		a = 10; //10이라는 값을 a라는 공간에 넣는다.
		
//자료의 형태 - 학번(문자형) 성명(문자형) 학과(문자형) 나이(숫자형) 성별(논리형,불린형) 점수(실수형,변수) 객체형(의사들의모임,개발자들의모임)
		String hakbun;
		String name;
		String dept;
		int age;
		boolean sex;
		double jumsu;
		Doctor doctor; //프로그래머가 만들어준 객체 자료형
		Programmer programmer;
	}	

}

class Doctor{
	
}
class Programmer{
	
}
//첫글자가 대문자인 것은 거의 대부분 객체
//. : ~안에  
//() : 소괄호  함수개념 x로 f 해라. f(x) = n*2 -5 f(2) = -1
//{} : 중괄호  메소드{함수의 처리할 내용}
//[] : 대괄호  배열
//<> : 다이아몬드괄호  라벨링
//실제로 개발은 이미 만들어진 것을 가져다 씀. 적잘하게 잘 쓰는것이 개발자의 역량.
//'' : 한글자 "" : 두글자부터
//컴퓨터의 가장 기본. 폰노이만 사람 주장. 
//**프로그램 내장방식 : 모든 프로그램은 반드시 주기억장치(RAM)에 올라가서 이것을 중앙처리장치가 가져다 연산하고 제어해서 수행한다.