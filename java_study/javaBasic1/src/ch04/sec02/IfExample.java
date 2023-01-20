package ch04.sec02;

public class IfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 78;
		
		if(a>=90) {
			System.out.println("점수는 90점 이상입니다");
			System.out.println("A등급입니다");
		}else if(a>=80) {
			System.out.println("점수는 80점 이상입니다");
			System.out.println("B등급입니다");
		}else if(a>=70) {
			System.out.println("점수는 70점 이상입니다");
			System.out.println("C등급입니다");
		}else
			System.out.println("점수는 70점 아래입니다");
			System.out.println("D등급입니다");

	}

}
